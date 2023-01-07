package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.ClientContractMapper;
import com.libiao.customer.dal.mapper.ClientContractMapperExt;
import com.libiao.customer.dal.model.ClientContract;
import com.libiao.customer.dal.model.ClientContractExample;
import com.libiao.customer.model.balance.BalanceReq;
import com.libiao.customer.model.client.contract.*;
import com.libiao.customer.service.BalanceService;
import com.libiao.customer.service.ContractService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.FileUtil;
import com.libiao.customer.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ClientContractMapper clientContractMapper;
    @Autowired
    private ClientContractMapperExt clientContractMapperExt;
    @Autowired
    private FileUtil fileUtil;

    @Autowired
    private BalanceService balanceService;


    @Override
    public PageInfo<ClientContractListVO> list(ClientContractListReq req){
        PageInfo<ClientContractListVO> page = new PageInfo<>();
        page.setPageSize(req.getPageSize());
        page.setPageNum(req.getPage());
        List<ClientContractListVO> clientContractList = clientContractMapperExt.getClientContractList(req);
        page = new PageInfo<>(clientContractList);
        return page;
    }

    @Override
    public void addContract(AddContractReq req){
        ClientContract record = BeanCopyUtil.copy(req,ClientContract.class);
        clientContractMapper.insertSelective(record);
    }

    @Override
    public ClientContract getClientByNum(String clientNum) {
        ClientContractExample example = new ClientContractExample();
        example.createCriteria().andClientNameEqualTo(clientNum);
        List<ClientContract> list = clientContractMapper.selectByExample(example);
        if(list.size() != 1) return null;
        return list.get(0);
    }

    @Override
    public ClientContractDetailVO detail(ContractDetailReq req){
        ClientContract clientContract = clientContractMapper.selectByPrimaryKey(req.getClientId());
        if (clientContract == null){
            throw new ServiceException(HttpStatus.NOT_FOUND,"合同未找到");
        }
        return BeanCopyUtil.copy(clientContract, ClientContractDetailVO.class);
    }

    @Override
    public void modify(ModifyContractReq req){
        ClientContract record = BeanCopyUtil.copy(req,ClientContract.class);
        record.setUpdateTime(new Date());
        clientContractMapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional
    public void review(ReviewContractReq req){
        ClientContract record = new ClientContract();
        record.setClientId(req.getClientId());
        record.setContractStatus(req.getReviewStatus());
        record.setReviewTime(new Date());
        record.setReviewId(req.getUser().getId());
        record.setReviewName(req.getUser().getNickname());
        record.setReviewReason(req.getReviewReason());
        clientContractMapper.updateByPrimaryKeySelective(record);

        record = clientContractMapper.selectByPrimaryKey(req.getClientId());
        //合同审核通过后,往balance表添加数据
        if(req.getReviewStatus()==(byte)1){
            BalanceReq balanceReq = new BalanceReq();
            balanceReq.setUser(req.getUser());
            balanceReq.setBalanceAmt(0L);
            balanceReq.setClientId(record.getClientNum());
            balanceReq.setCommissionRate(0L);
            balanceReq.setUnsettledAmt(0L);
            balanceReq.setCommissionRate(0L);
            balanceService.addRecord(balanceReq);
        }


    }

    @Override
    public void download(String fileName,HttpServletResponse response){
        fileUtil.downloadContract(fileName, response);
    }
}

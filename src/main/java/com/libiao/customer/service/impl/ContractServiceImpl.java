package com.libiao.customer.service.impl;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.ClientContractMapper;
import com.libiao.customer.dal.mapper.ClientContractMapperExt;
import com.libiao.customer.dal.model.ClientContract;
import com.libiao.customer.model.client.contract.*;
import com.libiao.customer.service.ContractService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.FileUtil;
import com.libiao.customer.util.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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
    public void addContract(AddContractReq req, MultipartFile file){
        ClientContract record = BeanCopyUtil.copy(req,ClientContract.class);
        //保存文件
        String fileName = fileUtil.saveContract(file, req.getClientId());
        record.setContractPath(fileName);
        clientContractMapper.insertSelective(record);
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
    public void modify(ModifyContractReq req, MultipartFile file){
        ClientContract record = BeanCopyUtil.copy(req,ClientContract.class);
        if (file != null){
            //保存文件
            String fileName = fileUtil.saveContract(file, req.getClientId());
            record.setContractPath(fileName);
        }
        record.setUpdateTime(new Date());
        clientContractMapper.updateByPrimaryKey(record);
    }

    @Override
    public void review(ReviewContractReq req){
        ClientContract record = new ClientContract();
        record.setClientId(req.getClientId());
        record.setContractStatus(req.getReviewStatus());
        record.setReviewTime(new Date());
        record.setReviewId(req.getUser().getId());
        record.setReviewName(req.getUser().getNickname());
        record.setReviewReason(req.getReviewReason());
        clientContractMapper.updateByPrimaryKey(record);
    }

    @Override
    public void download(String fileName,HttpServletResponse response){
        fileUtil.downloadContract(fileName, response);
    }
}

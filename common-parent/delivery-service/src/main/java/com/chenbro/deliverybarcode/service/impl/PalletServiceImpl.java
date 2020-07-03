package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.BarcodeHistory;
import com.chenbro.deliverybarcode.model.Box;
import com.chenbro.deliverybarcode.model.Pallet;
import com.chenbro.deliverybarcode.model.PalletQueryCond;
import com.chenbro.deliverybarcode.model.base.BarcodeType;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.IPalletService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.BarcodeHistoryUtils;
import com.chenbro.deliverybarcode.utils.DateUtils;
import com.chenbro.deliverybarcode.utils.UuidUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName PalletServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/19 11:54
 * @Version 1.0
 **/
@Service
@Transactional
public class PalletServiceImpl extends BaseServiceImpl<Pallet> implements IPalletService {

    @Override
    public Pallet findById(String id) {
        Pallet pallet = palletMapper.findById(id);
        if(pallet != null){
            pallet.setBoxes(boxMapper.findBoxsByPalletNo(id));
        }
        return pallet;
    }

    @Override
    public List<Pallet> findAll(Integer pageNum, Integer pageSize, String cusNo) {
        PageHelper.startPage(pageNum,pageSize);
        return palletMapper.findAll(cusNo);
    }

    @Override
    public Pallet findByUUid(String uuid) {
        return null;
    }

    @Override
    public void deleteById(String uuid) {

    }

    @Override
    public void update(Pallet pallet) {
        pallet.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
        palletMapper.update(pallet);
    }

    @Override
    public void insert(Pallet pallet) {

    }


    @Override
    public Pallet findDetailById(String uuid) {
        return palletMapper.findDetailById(uuid);
    }

    @Override
    public List<Pallet> queryPalletReportByCond(PalletQueryCond palletQueryCond) {
        return palletMapper.queryPalletReportByCond(palletQueryCond);
    }


    @Override
    public Result replyUpdate(String barcode, String statusCode) {
        //barcode 統一為棧板號.  1.判斷當前棧板號是否有效
        Pallet pallet = palletMapper.findById(barcode);
        if(pallet == null){
            return new Result(ResultCode.INVALIDID);
        }else{
            if(ObjectUtils.isEmpty(statusCode)){
                return  new Result(ResultCode.INVALIDIDSTATUS);
            }
            if(statusCode.equals(pallet.getStatus())){
                return new Result(ResultCode.STATUSREPEAT);
            }
            List<Box> boxes = boxMapper.findBoxsByPalletNo(barcode);
            for(Box boxItem : boxes){
                    boxItem.setCartonStatus(statusCode);
                    boxItem.setUpdateBy("VMI-User");
                    boxItem.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
                    boxMapper.updateStatus(boxItem);            //更新裝箱單裝箱單

                    //增加一條barcode 歷史記錄
//                BarcodeHistory barcodeHistory = BarcodeHistoryUtils.buildBarcodeHistory(boxItem.getCartonNo(),statusCode,"VMI-User",BarcodeType.BOX);
//                barcodeHistoryMapper.insert(barcodeHistory);
            }
            pallet.setStatus(statusCode);
            pallet.setUpdateBy("VMI-User");
            pallet.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
            palletMapper.update(pallet);
            BarcodeHistory barcodeHistory = BarcodeHistoryUtils.buildBarcodeHistory(pallet.getPalletNo(),statusCode,"VMI-User",BarcodeType.PALLET);
            barcodeHistoryMapper.insert(barcodeHistory);
            return new Result(ResultCode.SUCCESS);
    }
    }
}

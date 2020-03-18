package com.chenbro.deliverybarcode.service.impl;

import com.chenbro.deliverybarcode.model.Box;
import com.chenbro.deliverybarcode.model.InspurPallet;
import com.chenbro.deliverybarcode.model.base.BoxStatus;
import com.chenbro.deliverybarcode.model.base.Result;
import com.chenbro.deliverybarcode.model.base.ResultCode;
import com.chenbro.deliverybarcode.service.IBoxService;
import com.chenbro.deliverybarcode.service.base.BaseServiceImpl;
import com.chenbro.deliverybarcode.utils.DateUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName BoxServiceImpl
 * @Description TODO
 * @Author c8777
 * @Date 2020/2/14 11:21
 * @Version 1.0
 **/
@Service
@Transactional
public class BoxServiceImpl extends BaseServiceImpl<Box> implements IBoxService {



    @Override
    public Box findByUUid(String uuid) {
        return boxMapper.findByUUid(uuid);
    }

    @Override
    public void deleteById(String uuid) {
         boxMapper.deleteById(uuid);
    }

    @Override
    public void update(Box box) {
        boxMapper.update(box);
    }

    @Override
    public void insert(Box box) {
        boxMapper.insert(box);
    }


    @Override
    public Result receive(String cartonNo) {
        //查询当前carton 是否Carton No/ Pallet No
        Box box = boxMapper.findById(cartonNo);
        if(box == null){
            List<Box> boxes = boxMapper.findBoxsByPalletNo(cartonNo);
            if(boxes == null || boxes.size() < 1){
                return new Result(ResultCode.INVALIDID);
            }
            boolean handle = false;
            for(Box boxItem : boxes){
                if(boxItem.getCartonStatus().equals("1") || boxItem.getCartonStatus().equals("0")){
                    boxItem.setCartonStatus("2");
                    boxItem.setUpdateBy("C8777");
                    boxItem.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
                    boxMapper.updateStatus(boxItem);
                }
            }
            if(handle){
                return new Result(ResultCode.SUCCESS,boxes);
            }else{
                return new Result(ResultCode.INCONFORMITY,boxes);
            }

        }
        if(box.getCartonStatus().equals("1") || box.getCartonStatus().equals("0")){
            box.setCartonStatus("2");
            box.setUpdateBy("C8777");
            box.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
            boxMapper.updateStatus(box);
            return new Result(ResultCode.SUCCESS,box);
        }
        return new Result(ResultCode.INCONFORMITY,box);
    }

    @Override
    public Result shipping(String id) {
        //查询当前carton 是否Carton No/ Pallet No
        Box box = boxMapper.findById(id);
        if(box == null){
            List<Box> boxes = boxMapper.findBoxsByPalletNo(id);
            if(boxes == null || boxes.size() < 1){
                return new Result(ResultCode.INVALIDID);
            }
            boolean handle = false;
            for(Box boxItem : boxes){
                if(boxItem.getCartonStatus().equals("2")){
                    handle = true;
                    boxItem.setCartonStatus("3");
                    boxItem.setUpdateBy("C8777");
                    boxItem.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
                    boxMapper.updateStatus(boxItem);
                }
            }
            if(handle){
                return new Result(ResultCode.SUCCESS,boxes);
            }else{
                return new Result(ResultCode.INCONFORMITY,boxes);
            }

        }
        if(box.getCartonStatus().equals("2")){
            box.setCartonStatus("3");
            box.setUpdateBy("C8777");
            box.setUpdateDate(DateUtils.date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
            boxMapper.updateStatus(box);
            return new Result(ResultCode.SUCCESS,box);
        }
        return new Result(ResultCode.INCONFORMITY,box);
    }


    @Override
    public List<Box> findAllReceive() {
        List<Box> boxes = boxMapper.findBoxsByStatus(BoxStatus.RECEIVE.getValue());
        return boxes;
    }


    @Override
    public List<Box> findAllShipping() {
        List<Box> boxes = boxMapper.findBoxsByStatus(BoxStatus.SHIPPING.getValue());
        return boxes;
    }

    @Override
    public Result findReiveById(String id) {
        List<Box> boxes = new ArrayList<Box>();
        Box box = boxMapper.findById(id);
        if(box == null){
            boxes =boxMapper.findBoxsByPalletNo(id);
            return new Result(ResultCode.SUCCESS,boxes);
        }
        boxes.add(box);
        return new Result(ResultCode.SUCCESS,boxes);
    }

    public List<Box> findAll() {
        List<Box> boxes = boxMapper.findBoxsByStatus(null);
        return boxes;
    }

    @Override
    public Integer findQtysByStatus(String status) {
        return boxMapper.findQtysByStatus(status);
    }

    @Override
    public List<InspurPallet> findAllInspurPallet(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return boxMapper.findAllInspurPallet();
    }
}

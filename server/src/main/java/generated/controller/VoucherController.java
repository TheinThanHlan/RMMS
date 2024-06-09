package controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import dao.*;
import bean.*;

@RestController()
public class VoucherController {

    @Autowired()
    VoucherDao dao;

    @PostMapping("createVoucher")
    public String create(
            @RequestBody() Voucher dataVoucher) {
        dao.create(dataVoucher);
        return dataVoucher.toJson();

    }

    @PostMapping("readVoucherFromId")
    public String readVoucherFromId(
            @RequestBody() int id) {
        try {
            return dao.readFromId(id).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("readVoucher")
    public String read(
            @RequestBody() Voucher dataVoucher) {
        try {
            return dao.read(dataVoucher).toJson();

        } catch (NullPointerException e) {
            return null;

        }

    }

    @PostMapping("updateVoucher")
    public void update(
            @RequestBody() Voucher dataVoucher) {
        dao.update(dataVoucher);

    }

    @PostMapping("deleteVoucher")
    public String delete(
            @RequestBody() long id) {
        try {
            dao.delete(id);
            return "true";

        } catch (Exception e) {
            return "false";

        }

    }

    @PostMapping("readTodayOpenedVouchers")
    public String readTodayOpenedVouchers(@RequestBody() long restaurantId) {
        try {
            return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                    .toJson(this.dao.readTodayOpenedVouchers(restaurantId));
        } catch (NullPointerException e) {
            return null;

        }
    }

    @PostMapping("readAllVouchers")
    public String readAllVouchers(@RequestBody() Voucher voucher) {
        try {
            return new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                    .toJson(this.dao.readAllVouchers(voucher));
        } catch (NullPointerException e) {
            return null;

        }
    }

    @PostMapping("closeVoucher")
    public int closeVoucher(@RequestBody() Voucher voucher) {
        try {
            return this.dao.closeVoucher(voucher);

        } catch (NullPointerException e) {
            return 0;

        }
    }
}

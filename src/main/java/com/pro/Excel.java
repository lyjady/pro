package com.pro;

import com.pro.Entities.Address;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Excel {

    private WritableWorkbook book = null;

    private Workbook workbook = null;

    /**
     * 创建一个myExcel的Excel表格,其中第一个工作表名为sheet_one
     */
    @Test
    public void createExcel() {
        try {
            File file = new File("D:/pro/");
            if (!file.exists()) {
                file.mkdirs();
            }
            //新建Excel文件
            book = Workbook.createWorkbook(new File("D:/pro/AddressBook.xls"));
            //新建标签页
            WritableSheet sheet_one = book.createSheet("sheet_one", 0);
            //新建单元格
            Label label_0_0 = new Label(0, 0, "HelloWord");
            //将单元格添加到sheet中
            sheet_one.addCell(label_0_0);
            //保存数字的单元格
            Number number = new Number(0, 1, 123456);
            sheet_one.addCell(number);
            //IO流写出
            book.write();
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void readExcel() {
        try {
            workbook = Workbook.getWorkbook(new File("D:/pro/AddressBook.xls"));
            Sheet sheet = workbook.getSheet("sheet_one");
            int columns = sheet.getColumns();
            int rows = sheet.getRows();
            System.out.println("总列数:" + columns);
            System.out.println("总行数:" + rows);
            System.out.println(sheet.getCell(0, 1).getContents());

            List<Address> addresses = new ArrayList<Address>();
            Address address = null;

            for (int r = 1; r < rows; r++) {
                address = new Address();
                for (int c = 0; c < columns; c++) {
                    switch (c) {
                        case 0:
                            address.setId(Integer.parseInt(sheet.getCell(c, r).getContents()));
                            break;
                        case 1:
                            address.setDepartment(sheet.getCell(c, r).getContents());
                            break;
                        case 2:
                            address.setName(sheet.getCell(c, r).getContents());
                            break;
                        case 3:
                            address.setPost(sheet.getCell(c, r).getContents());
                            break;
                        case 4:
                            address.setOffice(sheet.getCell(c, r).getContents());
                            break;
                        case 5:
                            address.setHome(sheet.getCell(c, r).getContents());
                            break;
                        case 6:
                            address.setTel(sheet.getCell(c, r).getContents());
                            break;
                    }
                }
                addresses.add(address);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ouputAddressPerson() {
        try {
            File file = new File("D:/pro/");
            if (!file.exists()) {
                file.mkdirs();
            }

            file = new File(file, "person.xls");
            book = Workbook.createWorkbook(file);
            WritableSheet sheet = book.createSheet("sheet1", 0);

            Label id = new Label(0, 0, "ID");
            Label department = new Label(1, 0, "department");
            Label name = new Label(2, 0, "name");
            Label post = new Label(3, 0, "post");
            Label office = new Label(4, 0 ,"office");
            Label home = new Label(5, 0, "home");
            Label tel = new Label(6, 0, "tel");

            sheet.addCell(id);
            sheet.addCell(department);
            sheet.addCell(name);
            sheet.addCell(post);
            sheet.addCell(office);
            sheet.addCell(home);
            sheet.addCell(tel);

            List<Address> addresses = new ArrayList<Address>();
            addresses.add(new Address(1, "省委", "aaa", "123", "123", "123", "123"));
            addresses.add(new Address(2, "市委", "bbb", "123", "123", "123", "123"));
            addresses.add(new Address(3, "县委", "ccc", "123", "123", "123", "123"));
            addresses.add(new Address(4, "乡委", "ddd", "123", "123", "123", "123"));
            addresses.add(new Address(5, "村委", "eee", "123", "123", "123", "123"));

            int column = 7;

            for (int i = 0; i < addresses.size(); i++) {
                Label label = null;
                for (int c = 0; c < column; c++) {
                    switch (c) {
                        case 0:
                            label = new Label(c, i + 1, String.valueOf(addresses.get(i).getId()));
                            sheet.addCell(label);
                            break;
                        case 1:
                            label = new Label(c, i + 1, addresses.get(i).getDepartment());
                            sheet.addCell(label);
                            break;
                        case 2:
                            label = new Label(c, i + 1, addresses.get(i).getName());
                            sheet.addCell(label);
                            break;
                        case 3:
                            label = new Label(c, i + 1, addresses.get(i).getPost());
                            sheet.addCell(label);
                            break;
                        case 4:
                            label = new Label(c, i + 1, addresses.get(i).getOffice());
                            sheet.addCell(label);
                            break;
                        case 5:
                            label = new Label(c, i + 1, addresses.get(i).getHome());
                            sheet.addCell(label);
                            break;
                        case 6 :
                            label = new Label(c, i + 1, addresses.get(i).getTel());
                            sheet.addCell(label);
                            break;
                    }
                }
            }
            book.write();
            book.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        }
    }
}

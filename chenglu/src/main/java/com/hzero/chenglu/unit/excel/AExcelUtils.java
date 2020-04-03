package com.hzero.chenglu.unit.excel;


import com.hzero.chenglu.entity.A;
import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * excel导入获取数据，只获取第一个sheet页
 */
public class AExcelUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(AExcelUtils.class);

    public static List<A> excelToShopIdList(InputStream inputStream) {
        List<A> list = new ArrayList<A>();
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(inputStream);
            inputStream.close();
            //工作表对象
            Sheet sheet = workbook.getSheetAt(0);
            //总行数
            int rowLength = sheet.getLastRowNum() + 1;
            //工作表的列
            Row row = (Row) sheet.getRow(0);

            //总列数
            int colLength = row.getLastCellNum();
            //得到指定的单元格
            Cell cell = row.getCell(0);
            for (int i = 1; i < rowLength; i++) {
                A a = new A();
                row = sheet.getRow(i);
                try {
                    if (row.getCell(0) != null) {
                        row.getCell(0).setCellType(CellType.STRING);
                    }
                    if (row.getCell(1) != null) {
                        row.getCell(1).setCellType(CellType.STRING);
                    }
                    if (row.getCell(2) != null) {
                        row.getCell(2).setCellType(CellType.STRING);
                    }
                    if (row.getCell(3) != null) {
                        row.getCell(3).setCellType(CellType.STRING);
                    }
                    if (row.getCell(4) != null) {
                        row.getCell(4).setCellType(CellType.STRING);
                    }
                    if (row.getCell(5) != null) {
                        row.getCell(5).setCellType(CellType.STRING);
                    }
                    if (row.getCell(6) != null) {
                        row.getCell(6).setCellType(CellType.STRING);
                    }
                    if (row.getCell(7) != null) {
                        row.getCell(7).setCellType(CellType.STRING);
                    }
                    if (row.getCell(8) != null) {
                        row.getCell(8).setCellType(CellType.STRING);
                    }
                    if (row.getCell(9) != null) {
                        row.getCell(9).setCellType(CellType.STRING);
                    }
                    if (row.getCell(10) != null) {
                        row.getCell(10).setCellType(CellType.STRING);
                    }
                    if (row.getCell(11) != null) {
                        row.getCell(11).setCellType(CellType.STRING);
                    }
                    if (row.getCell(12) != null) {
                        row.getCell(12).setCellType(CellType.STRING);
                    }
                    if (row.getCell(13) != null) {
                        row.getCell(13).setCellType(CellType.STRING);
                    }
                    if (row.getCell(14) != null) {
                        row.getCell(14).setCellType(CellType.STRING);
                    }
                    if (row.getCell(15) != null) {
                        row.getCell(15).setCellType(CellType.STRING);
                    }
                    if (row.getCell(16) != null) {
                        row.getCell(16).setCellType(CellType.STRING);
                    }
                    if (row.getCell(17) != null) {
                        row.getCell(17).setCellType(CellType.STRING);
                    }
                    if (row.getCell(18) != null) {
                        row.getCell(18).setCellType(CellType.STRING);
                    }
                    if (row.getCell(19) != null) {
                        row.getCell(19).setCellType(CellType.STRING);
                    }
                    if (row.getCell(20) != null) {
                        row.getCell(20).setCellType(CellType.STRING);
                    }
                    if (row.getCell(21) != null) {
                        row.getCell(21).setCellType(CellType.STRING);
                    }
                    if (row.getCell(22) != null) {
                        row.getCell(22).setCellType(CellType.STRING);
                    }
                    if (row.getCell(23) != null) {
                        row.getCell(23).setCellType(CellType.STRING);
                    }
                    if (row.getCell(24) != null) {
                        row.getCell(24).setCellType(CellType.STRING);
                    }
                    if (row.getCell(25) != null) {
                        row.getCell(25).setCellType(CellType.STRING);
                    }
                    if (row.getCell(26) != null) {
                        row.getCell(26).setCellType(CellType.STRING);
                    }
                    if (row.getCell(27) != null) {
                        row.getCell(27).setCellType(CellType.STRING);
                    }
                    if (row.getCell(28) != null) {
                        row.getCell(28).setCellType(CellType.STRING);
                    }
                    if (row.getCell(29) != null) {
                        row.getCell(29).setCellType(CellType.STRING);
                    }
                    if (row.getCell(30) != null) {
                        row.getCell(30).setCellType(CellType.STRING);
                    }
                    if (row.getCell(31) != null) {
                        row.getCell(31).setCellType(CellType.STRING);
                    }
                    if (row.getCell(32) != null) {
                        row.getCell(32).setCellType(CellType.STRING);
                    }
                    if (row.getCell(33) != null) {
                        row.getCell(33).setCellType(CellType.STRING);
                    }
                    if (row.getCell(34) != null) {
                        row.getCell(34).setCellType(CellType.STRING);
                    }
                    if (row.getCell(35) != null) {
                        row.getCell(35).setCellType(CellType.STRING);
                    }
                    if (row.getCell(36) != null) {
                        row.getCell(36).setCellType(CellType.STRING);
                    }
                    if (row.getCell(37) != null) {
                        row.getCell(37).setCellType(CellType.STRING);
                    }
                    if (row.getCell(38) != null) {
                        row.getCell(38).setCellType(CellType.STRING);
                    }
                    if (row.getCell(39) != null) {
                        row.getCell(39).setCellType(CellType.STRING);
                    }
                    if (row.getCell(40) != null) {
                        row.getCell(40).setCellType(CellType.STRING);
                    }
                    if (row.getCell(41) != null) {
                        row.getCell(41).setCellType(CellType.STRING);
                    }
                    if (row.getCell(42) != null) {
                        row.getCell(42).setCellType(CellType.STRING);
                    }
                    if (row.getCell(43) != null) {
                        row.getCell(43).setCellType(CellType.STRING);
                    }
                    if (row.getCell(44) != null) {
                        row.getCell(44).setCellType(CellType.STRING);
                    }
                    if (row.getCell(45) != null) {
                        row.getCell(45).setCellType(CellType.STRING);
                    }
                    if (row.getCell(46) != null) {
                        row.getCell(46).setCellType(CellType.STRING);
                    }
                    if (row.getCell(47) != null) {
                        row.getCell(47).setCellType(CellType.STRING);
                    }
                    if (row.getCell(48) != null) {
                        row.getCell(48).setCellType(CellType.STRING);
                    }
                    if (row.getCell(49) != null) {
                        row.getCell(49).setCellType(CellType.STRING);
                    }
                    if (row.getCell(50) != null) {
                        row.getCell(50).setCellType(CellType.STRING);
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {


                    //获取每一个单元格的数据并且放入实体类中
                    if (row.getCell(0) != null) {
                        a.setA1(row.getCell(0).getRichStringCellValue().getString());
                    }
                    if (row.getCell(1) != null) {
                        a.setA2(row.getCell(1).getRichStringCellValue().getString());
                    }
                    if (row.getCell(2) != null) {
                        a.setA3(row.getCell(2).getRichStringCellValue().getString());
                    }
                    if (row.getCell(3) != null) {
                        a.setA4(row.getCell(3).getRichStringCellValue().getString());
                    }
                    if (row.getCell(4) != null) {
                        a.setA5(row.getCell(4).getRichStringCellValue().getString());
                    }
                    if (row.getCell(5) != null) {
                        a.setA6(row.getCell(5).getRichStringCellValue().getString());
                    }
                    if (row.getCell(6) != null) {
                        a.setA7(row.getCell(6).getRichStringCellValue().getString());
                    }
                    if (row.getCell(7) != null) {
                        a.setA8(row.getCell(7).getRichStringCellValue().getString());
                    }
                    if (row.getCell(8) != null) {
                        a.setA9(row.getCell(8).getRichStringCellValue().getString());
                    }
                    if (row.getCell(9) != null) {
                        a.setA10(row.getCell(9).getRichStringCellValue().getString());
                    }
                    if (row.getCell(10) != null) {
                        a.setA11(row.getCell(10).getRichStringCellValue().getString());
                    }
                    if (row.getCell(11) != null) {
                        a.setA12(row.getCell(11).getRichStringCellValue().getString());
                    }
                    if (row.getCell(12) != null) {
                        a.setA13(row.getCell(12).getRichStringCellValue().getString());
                    }
                    if (row.getCell(13) != null) {
                        a.setA14(row.getCell(13).getRichStringCellValue().getString());
                    }
                    if (row.getCell(14) != null) {
                        a.setA15(row.getCell(14).getRichStringCellValue().getString());
                    }
                    if (row.getCell(15) != null) {
                        a.setA16(row.getCell(15).getRichStringCellValue().getString());
                    }
                    if (row.getCell(16) != null) {
                        a.setA17(row.getCell(16).getRichStringCellValue().getString());
                    }
                    if (row.getCell(17) != null) {
                        a.setA18(row.getCell(17).getRichStringCellValue().getString());
                    }
                    if (row.getCell(18) != null) {
                        a.setA19(row.getCell(18).getRichStringCellValue().getString());
                    }
                    if (row.getCell(19) != null) {
                        a.setA20(row.getCell(19).getRichStringCellValue().getString());
                    }
                    if (row.getCell(20) != null) {
                        a.setA21(row.getCell(20).getRichStringCellValue().getString());
                    }
                    if (row.getCell(21) != null) {
                        a.setA22(row.getCell(21).getRichStringCellValue().getString());
                    }
                    if (row.getCell(22) != null) {
                        a.setA23(row.getCell(22).getRichStringCellValue().getString());
                    }
                    if (row.getCell(23) != null) {
                        a.setA24(row.getCell(23).getRichStringCellValue().getString());
                    }
                    if (row.getCell(24) != null) {
                        a.setA25(row.getCell(24).getRichStringCellValue().getString());
                    }
                    if (row.getCell(25) != null) {
                        a.setA26(row.getCell(25).getRichStringCellValue().getString());
                    }
                    if (row.getCell(26) != null) {
                        a.setA27(row.getCell(26).getRichStringCellValue().getString());
                    }
                    if (row.getCell(27) != null) {
                        a.setA28(row.getCell(27).getRichStringCellValue().getString());
                    }
                    if (row.getCell(28) != null) {
                        a.setA29(row.getCell(28).getRichStringCellValue().getString());
                    }
                    if (row.getCell(29) != null) {
                        a.setA30(row.getCell(29).getRichStringCellValue().getString());
                    }
                    if (row.getCell(30) != null) {
                        a.setA31(row.getCell(30).getRichStringCellValue().getString());
                    }
                    if (row.getCell(31) != null) {
                        a.setA32(row.getCell(31).getRichStringCellValue().getString());
                    }
                    if (row.getCell(32) != null) {
                        a.setA33(row.getCell(32).getRichStringCellValue().getString());
                    }
                    if (row.getCell(33) != null) {
                        a.setA34(row.getCell(33).getRichStringCellValue().getString());
                    }
                    if (row.getCell(34) != null) {
                        a.setA35(row.getCell(34).getRichStringCellValue().getString());
                    }
                    if (row.getCell(35) != null) {
                        a.setA36(row.getCell(35).getRichStringCellValue().getString());
                    }
                    if (row.getCell(36) != null) {
                        a.setA37(row.getCell(36).getRichStringCellValue().getString());
                    }
                    if (row.getCell(37) != null) {
                        a.setA38(row.getCell(37).getRichStringCellValue().getString());
                    }
                    if (row.getCell(38) != null) {
                        a.setA39(row.getCell(38).getRichStringCellValue().getString());
                    }
                    if (row.getCell(39) != null) {
                        a.setA40(row.getCell(39).getRichStringCellValue().getString());
                    }
                    if (row.getCell(40) != null) {
                        a.setA41(row.getCell(40).getRichStringCellValue().getString());
                    }
                    if (row.getCell(41) != null) {
                        a.setA42(row.getCell(41).getRichStringCellValue().getString());
                    }
                    if (row.getCell(42) != null) {
                        a.setA43(row.getCell(42).getRichStringCellValue().getString());
                    }
                    if (row.getCell(43) != null) {
                        a.setA44(row.getCell(43).getRichStringCellValue().getString());
                    }
                    if (row.getCell(44) != null) {
                        a.setA45(row.getCell(44).getRichStringCellValue().getString());
                    }
                    if (row.getCell(45) != null) {
                        a.setA46(row.getCell(45).getRichStringCellValue().getString());
                    }
                    if (row.getCell(46) != null) {
                        a.setA47(row.getCell(46).getRichStringCellValue().getString());
                    }
                    if (row.getCell(47) != null) {
                        a.setA48(row.getCell(47).getRichStringCellValue().getString());
                    }
                    if (row.getCell(48) != null) {
                        a.setA49(row.getCell(48).getRichStringCellValue().getString());
                    }
                    if (row.getCell(49) != null) {
                        a.setA50(row.getCell(49).getRichStringCellValue().getString());
                    }


//                for (int j = 0; j < 9; j++) {
//                    cell = row.getCell(j);
//                    System.out.println(cell.getRichStringCellValue().getString());
//                    if (cell != null) {
//                        cell.setCellType(Cell.CELL_TYPE_STRING);
//                        String data = cell.getRichStringCellValue().getString();
//                        data = data.trim();
//                        if (StringUtils.isNumeric(data))
//                            list.add(Integer.parseInt(data));
//                    }
//                }
                    list.add(a);
                }
            }
        } catch (Exception e) {
            LOGGER.error("parse excel file error :", e);
            System.out.println("异常：" + e.getMessage());
        }
        return list;
    }

//    public static List<Object[]> excelToShopIdList2(File file) {
//        List<Object[]> list = new ArrayList<>();
//        try {
//            Workbook wb = null;
//            String fileName = file.getName();
//            if (fileName.toUpperCase().endsWith("XLS")) {
//                wb = new HSSFWorkbook(new FileInputStream(file));
//            } else if (fileName.toUpperCase().endsWith("XLSX")) {
//                wb = new XSSFWorkbook(new FileInputStream(file));
//            }
//            // 把一张xls的数据表读到wb里
//            // 读取第一页,一般一个excel文件会有三个工作表，这里获取第一个工作表来进行操作 HSSFSheet sheet =
//            // wb.getSheetAt(0);
//            Sheet sheet = wb.getSheetAt(0);
//            DecimalFormat df = new DecimalFormat("0");
//            // 循环遍历表sheet.getLastRowNum()是获取一个表最后一条记录的记录号，
//            int maxNum = sheet.getLastRowNum();
//            //每一列数据长度应该写死，否则后面遍历取最后列的值会报数组越界异常
//            Row row1 = sheet.getRow(0);
//            int maxRow1 = row1.getLastCellNum();
//
//            // 如果总共有3条记录，那获取到的最后记录号就为2，因为是从0开始的
//            for (int j = 0; j < maxNum + 1; j++) {
//                // 创建一个行对象
//                Row row = sheet.getRow(j);
//                // 把一行里的每一个字段遍历出来
//                if (row == null) {
//                    continue;
//                } else {
//                    int maxRow = row.getLastCellNum();
//                    //跳过纯空数据
//                    if (maxRow < 1) {
//                        continue;
//                    }
//                    String[] str2 = new String[maxRow1];
//                    for (int i = 0; i < maxRow; i++) {
//                        // 创建一个行里的一个字段的对象，也就是获取到的一个单元格中的值
//                        Cell cell = row.getCell(i);
//                        // if (cell != null) {
//                        // System.out.println("类型:" + cell.getCellType());
//                        // }
//
//                        // 在这里我们就可以做很多自己想做的操作了，比如往数据库中添加数据等
//                        // System.out.println("第" + (j + 1) + "行的第" + i + "列的值："
//                        // + cell);
//                        if (cell != null) {
//                            if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) { //类型为数值
//                                str2[i] = df.format(cell.getNumericCellValue()); //防止数字变为科学计数
//                            } else {
//                                str2[i] = cell + "";
//                            }
//                        }
//                    }
//                    list.add(str2);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    /**
//     * 获取单元格数据
//     *
//     * @param cell
//     * @return
//     */
//    public static Object getCellFormatValue(Cell cell) {
//        Object cellValue = null;
//        if (cell != null) {
//            // 判断cell类型
//            switch (cell.getCellType()) {
//                case Cell.CELL_TYPE_NUMERIC: {
//                    cellValue = String.valueOf(cell.getNumericCellValue());
//                    break;
//                }
//                case Cell.CELL_TYPE_FORMULA: {
//                    // 判断cell是否为日期格式
//                    if (DateUtil.isCellDateFormatted(cell)) {
//                        // 转换为日期格式YYYY-mm-dd
//                        cellValue = cell.getDateCellValue();
//                    } else {
//                        // 数字
//                        cellValue = String.valueOf(cell.getNumericCellValue());
//                    }
//                    break;
//                }
//                case Cell.CELL_TYPE_STRING: {
//                    cellValue = cell.getRichStringCellValue().getString();
//                    break;
//                }
//                default:
//                    cellValue = "";
//            }
//        } else {
//            cellValue = "";
//        }
//        return cellValue;
//    }

}

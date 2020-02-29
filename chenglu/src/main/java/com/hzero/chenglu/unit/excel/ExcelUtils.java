package com.hzero.chenglu.unit.excel;


import com.hzero.chenglu.entity.HgylPersonInfo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * excel导入获取数据，只获取第一个sheet页
 *
 */
public class ExcelUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);

    public static List<HgylPersonInfo> excelToShopIdList(InputStream inputStream) {
        List<HgylPersonInfo> list = new ArrayList<HgylPersonInfo>();
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
                HgylPersonInfo hgylPersonInfo = new HgylPersonInfo();
                row = sheet.getRow(i);
                row.getCell(1).setCellType(CellType.STRING);
                row.getCell(6).setCellType(CellType.STRING);
                row.getCell(7).setCellType(CellType.STRING);
                //获取每一个单元格的数据并且放入实体类中
                hgylPersonInfo.setArea(row.getCell(0).getStringCellValue());//区域
                hgylPersonInfo.setJobNum(Long.parseLong(row.getCell(1).getStringCellValue()));//工号
                hgylPersonInfo.setName(row.getCell(2).getStringCellValue());//姓名
                hgylPersonInfo.setProject(row.getCell(3).getStringCellValue());//项目
                hgylPersonInfo.setWorking(row.getCell(4).getStringCellValue());//工作方式
                hgylPersonInfo.setSite(row.getCell(5).getStringCellValue());//地点
                hgylPersonInfo.setStartDate( row.getCell(6).getStringCellValue());//入场时间
                hgylPersonInfo.setEndDate(row.getCell(7).getStringCellValue());//撤离时间
                hgylPersonInfo.setRemark(row.getCell(8).getStringCellValue());//备注


//                for (int j = 0; j < 9; j++) {
//                    cell = row.getCell(j);
//                    System.out.println(cell.getStringCellValue());
//                    if (cell != null) {
//                        cell.setCellType(Cell.CELL_TYPE_STRING);
//                        String data = cell.getStringCellValue();
//                        data = data.trim();
//                        if (StringUtils.isNumeric(data))
//                            list.add(Integer.parseInt(data));
//                    }
//                }
                list.add(hgylPersonInfo);
            }
        } catch (Exception e) {
            LOGGER.error("parse excel file error :", e);
            System.out.println("异常："+e.getMessage());
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

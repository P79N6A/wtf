package cn.tc.ulife.platform.server.utils;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import cn.tc.ulife.platform.server.pay.model.PayOrderBean;
import cn.tc.ulife.platform.util.CRMUtil;

public class Snippet {
	

	
	 /**
		 * POI : 导出数据，存放于Excel中
		 * @param os 输出流 (action: OutputStream os = response.getOutputStream();)
		 * @param Goods 要导出的数据集合
		 */
//		public static void exportGoodsByPoi(HttpServletResponse response,List<GoodsVo> gbv) {
//			String filename="商品信息表.xls";
//			try {
//				response.setContentType("application/vnd.ms-excel; charset=utf-8");
//				response.setHeader("Content-Disposition","attachment;filename="+URLEncoder.encode(filename,"utf-8"));
//				response.setCharacterEncoding("utf-8");
//				OutputStream os=response.getOutputStream();
//				//创建Excel工作薄
//				HSSFWorkbook book = new HSSFWorkbook();
//				//在Excel工作薄中建一张工作表
//				HSSFSheet sheet = book.createSheet("商品信息表");
//				//设置单元格格式(文本)
//				//HSSFCellStyle cellStyle = book.createCellStyle();
//				
//				//第一行为标题行
//				HSSFRow row = sheet.createRow(0);//创建第一行
//				HSSFCell cell0 = row.createCell(0);
//				HSSFCell cell1 = row.createCell(1);
//				HSSFCell cell2 = row.createCell(2);
//				HSSFCell cell3 = row.createCell(3);
//				HSSFCell cell4 = row.createCell(4);
//				//定义单元格为字符串类型
//				cell0.setCellType(HSSFCell.CELL_TYPE_STRING);
//				cell1.setCellType(HSSFCell.CELL_TYPE_STRING);
//				cell2.setCellType(HSSFCell.CELL_TYPE_STRING);
//				cell3.setCellType(HSSFCell.CELL_TYPE_STRING);
//				cell4.setCellType(HSSFCell.CELL_TYPE_STRING);
//				//在单元格中输入数据
//				cell0.setCellValue("商品名称");
//				cell1.setCellValue("商品分类");
//				cell2.setCellValue("商品标签");
//				cell3.setCellValue("是否上架");
//				cell4.setCellValue("商品商家");
//				//循环导出数据到excel中
//				for(int i = 0; i < gbv.size(); i++) {
//					GoodsVo gb = gbv.get(i);
//					//创建第i行
//					HSSFRow rowi = sheet.createRow(i + 1);
//					//在第i行的相应列中加入相应的数据
//					rowi.createCell(0).setCellValue(gb.getName());
//					rowi.createCell(1).setCellValue(gb.getFlname());
//					rowi.createCell(2).setCellValue(gb.getBqname());
//					String issj ="";
//					if(!gb.getIssj().equals("0")){
//						issj="是";
//					}else{
//						issj="否";
//					}
//					rowi.createCell(3).setCellValue(issj);
//					rowi.createCell(4).setCellValue(gb.getStname());
//				}
//				//写入数据  把相应的Excel 工作簿存盘 
//				book.write(os);
//				book.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		
		/**
		 * POI : 导出交易记录数据，存放于Excel中
		 * @param os 输出流 (action: OutputStream os = response.getOutputStream();)
		 * @param Goods 要导出的数据集合
		 * @throws IOException 
		 */
		public static void exportDealRecord(HttpServletResponse response,List<PayOrderBean> gbv) throws IOException {
			String filename="交易记录表.xls";
			try {
					// 第一步，创建一个webbook，对应一个Excel文件  
					HSSFWorkbook workBook = new HSSFWorkbook();
					// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
					HSSFSheet sheet = null;
					HSSFRow headRow = null,row = null;
					HSSFCell headCell = null,cell = null;
					HSSFRichTextString head = null;
					//行标记数据开始写入行标记
					int index = 1;
					sheet = workBook.createSheet("交易记录");
					//创建第一行
					headRow = sheet.createRow(0);
					//第二行第一列
					headCell = headRow.createCell(0, HSSFCell.CELL_TYPE_STRING);
					head = new HSSFRichTextString("序号");
					headCell.setCellValue(head);
					headCell.setCellStyle(CRMUtil.getHeadStyle(workBook));
					sheet.setColumnWidth(0, 2000);
					
					headCell = headRow.createCell(1, HSSFCell.CELL_TYPE_STRING);
					head = new HSSFRichTextString("所属城市");
					headCell.setCellValue(head);
					headCell.setCellStyle(CRMUtil.getHeadStyle(workBook));
					sheet.setColumnWidth(1, 6000);
					
					headCell = headRow.createCell(2, HSSFCell.CELL_TYPE_STRING);
					head = new HSSFRichTextString("所属小区");
					headCell.setCellValue(head);
					headCell.setCellStyle(CRMUtil.getHeadStyle(workBook));
					sheet.setColumnWidth(2, 5000);
					
					headCell = headRow.createCell(3, HSSFCell.CELL_TYPE_STRING);
					head = new HSSFRichTextString("用户账号");
					headCell.setCellValue(head);
					headCell.setCellStyle(CRMUtil.getHeadStyle(workBook));
					sheet.setColumnWidth(3, 4000);
					
					headCell = headRow.createCell(4, HSSFCell.CELL_TYPE_STRING);
					head = new HSSFRichTextString("交易订单号");
					headCell.setCellValue(head);
					headCell.setCellStyle(CRMUtil.getHeadStyle(workBook));
					sheet.setColumnWidth(4, 3000);
					
					headCell = headRow.createCell(5, HSSFCell.CELL_TYPE_STRING);
					head = new HSSFRichTextString("支付账号");
					headCell.setCellValue(head);
					headCell.setCellStyle(CRMUtil.getHeadStyle(workBook));
					sheet.setColumnWidth(5, 3000);
					
					headCell = headRow.createCell(6, HSSFCell.CELL_TYPE_STRING);
					head = new HSSFRichTextString("账号类型");
					headCell.setCellValue(head);
					headCell.setCellStyle(CRMUtil.getHeadStyle(workBook));
					sheet.setColumnWidth(6, 3000);
					
					headCell = headRow.createCell(7, HSSFCell.CELL_TYPE_STRING);
					head = new HSSFRichTextString("交易金额");
					headCell.setCellValue(head);
					headCell.setCellStyle(CRMUtil.getHeadStyle(workBook));
					sheet.setColumnWidth(7, 3000);
					
					headCell = headRow.createCell(8, HSSFCell.CELL_TYPE_STRING);
					head = new HSSFRichTextString("收款账号");
					headCell.setCellValue(head);
					headCell.setCellStyle(CRMUtil.getHeadStyle(workBook));
					sheet.setColumnWidth(8, 3000);
					
					headCell = headRow.createCell(9, HSSFCell.CELL_TYPE_STRING);
					head = new HSSFRichTextString("交易时间");
					headCell.setCellValue(head);
					headCell.setCellStyle(CRMUtil.getHeadStyle(workBook));
					sheet.setColumnWidth(9, 3000);
					
					//给excel赋值
					for (int i=0;i<gbv.size();i++) {  
						row = sheet.createRow(index);
						//每行第1例序号
						cell = row.createCell(0,HSSFCell.CELL_TYPE_STRING);
						
						cell.setCellValue(new HSSFRichTextString(String.valueOf(i+1)));
						
						//每行第2商品
						cell = row.createCell(1,HSSFCell.CELL_TYPE_STRING);
						
						cell.setCellValue(new HSSFRichTextString(gbv.get(i).getArid()));
						
						//每行第2商品分类
						cell = row.createCell(2,HSSFCell.CELL_TYPE_STRING);
						
						cell.setCellValue(new HSSFRichTextString(gbv.get(i).getComid()));
						
						//每行第3商品规格
						cell = row.createCell(3,HSSFCell.CELL_TYPE_STRING);
						
						cell.setCellValue(new HSSFRichTextString(gbv.get(i).getANAME()));
						
						//每行第3商品售价
						cell = row.createCell(4,HSSFCell.CELL_TYPE_STRING);
						
						cell.setCellValue(new HSSFRichTextString(gbv.get(i).getORDERBH()));
						
						//每行第3商品合格品量
						cell = row.createCell(5,HSSFCell.CELL_TYPE_STRING);
						
						cell.setCellValue(new HSSFRichTextString(gbv.get(i).getZaccount()));
						
						//每行第3实际称重
						cell = row.createCell(6,HSSFCell.CELL_TYPE_STRING);
						
						cell.setCellValue(new HSSFRichTextString(gbv.get(i).getAtype()));
						
						//每行第3应收金额
						cell = row.createCell(7,HSSFCell.CELL_TYPE_STRING);
						
						cell.setCellValue(new HSSFRichTextString(gbv.get(i).getDprice()));
						
						//每行第3实收金额
						cell = row.createCell(8,HSSFCell.CELL_TYPE_STRING);
						
						cell.setCellValue(new HSSFRichTextString(gbv.get(i).getTaccount()));
						
						//每行第3待扫码数
						cell = row.createCell(9,HSSFCell.CELL_TYPE_STRING);
						
						cell.setCellValue(new HSSFRichTextString(gbv.get(i).getCtime()));
						index++;
					}
					response.setContentType("application/octet-stream");
					response.setHeader("Content-Disposition", "attachment;filename="+ new String(filename.getBytes("GBK"), "ISO-8859-1"));
					workBook.write(response.getOutputStream());
				
				
			} catch (IOException e) {
				response.reset();
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			finally {
				response.flushBuffer();
			}
		}
		
		
		
		/** 
	     * POI:解析Excel文件中的数据并把每行数据封装成一个实体 
	     * @param fis 文件输入流 
	     * @return  WyBilllogExcel中数据封装实体的集合 
	     */  
//	    @SuppressWarnings({ "resource", "static-access" })
//		public static List<WyBilllogBean> importWyBilllogBeanByPoi(InputStream fis) {  
//	          
//	        List<WyBilllogBean> infos = new ArrayList<WyBilllogBean>();  
//	        WyBilllogBean wb = null;  
//	          
//	        try {  
//	        	HSSFWorkbook book =new HSSFWorkbook(fis);
//	            //得到第一个工作表  
//	        	HSSFSheet sheet = book.getSheetAt(0);  
//	        	HSSFRow row = null;  
//	            //日期格式化 
//	            //遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数   
//	           
//	                sheet = book.getSheetAt(0);  
//	                //遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数  
//	                for(int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {  
//	                    row = sheet.getRow(j);  
//	                    wb = new WyBilllogBean(); 
//	                   if(row.getCell(0).getCellType() == row.getCell(0).CELL_TYPE_NUMERIC){
//	                	  wb.setCommid(row.getCell(0).toString().substring(0, row.getCell(0).toString().indexOf('.')).trim());
//	                   }else{
//	                	   wb.setCommid(row.getCell(0).toString().trim());
//	                   }
//	                   if(row.getCell(1).getCellType() == row.getCell(1).CELL_TYPE_NUMERIC){
//	                	   wb.setPhase(row.getCell(1).toString().substring(0, row.getCell(1).toString().indexOf('.')).trim()+"期");
//	                   }else{
//	                	   wb.setPhase(row.getCell(1).toString().trim());
//	                   }
//	                   if(row.getCell(2).getCellType() == row.getCell(2).CELL_TYPE_NUMERIC){
//	                	   wb.setLdh(row.getCell(2).toString().substring(0, row.getCell(2).toString().indexOf('.')).trim()+"栋");
//	                   }else{
//	                	   wb.setLdh(row.getCell(2).toString().trim());
//	                   }
//	                   if(row.getCell(3).getCellType() == row.getCell(3).CELL_TYPE_NUMERIC){
//	                	   wb.setDyh(row.getCell(3).toString().substring(0, row.getCell(3).toString().indexOf('.')).trim()+"单元");
//	                   }else{
//	                	   wb.setDyh(row.getCell(3).toString().trim());
//	                   }
//	                   if(row.getCell(4).getCellType() == row.getCell(4).CELL_TYPE_NUMERIC){
//	                	   wb.setFjh(row.getCell(4).toString().substring(0, row.getCell(4).toString().indexOf('.')).trim()+"室");
//	                   }else{
//	                	   wb.setFjh(row.getCell(4).toString().trim());
//	                   }
//	                   if(row.getCell(5).getCellType() == row.getCell(5).CELL_TYPE_NUMERIC){
//	                	   wb.setAcreage(row.getCell(5).toString().substring(0, row.getCell(5).toString().indexOf('.')).trim());
//	                   }else{
//	                	   wb.setAcreage(row.getCell(5).toString().trim());
//	                   }
//	                   if(row.getCell(6).getCellType() == row.getCell(6).CELL_TYPE_NUMERIC){
//	                	   wb.setYjje(String.format("%.2f", Double.parseDouble(row.getCell(6).toString())));//四舍五入保留两位小数
//	                	   wb.setSjje(wb.getYjje());
//	                   }else{
//	                	   wb.setYjje(row.getCell(6).toString().trim());
//	                	   wb.setSjje(wb.getYjje());
//	                   }
//	                   if(row.getCell(7).getCellType() == row.getCell(7).CELL_TYPE_NUMERIC){
//	                	   wb.setZdrq(row.getCell(7).toString().substring(0, row.getCell(7).toString().indexOf('.')).trim());
//	                   }else{
//	                	   wb.setZdrq(row.getCell(7).toString().trim());
//	                   }
//	                   if(row.getCell(8).getCellType() == row.getCell(8).CELL_TYPE_NUMERIC){
//	                	   wb.setTel(row.getCell(8).toString().substring(0, row.getCell(8).toString().indexOf('.')).trim());
//	                   }else{
//	                	   wb.setTel(row.getCell(8).toString().trim());
//	                   }
//	                   if(null != row.getCell(9)){
//		                   if(row.getCell(9).getCellType() == row.getCell(9).CELL_TYPE_NUMERIC){
//		                	   wb.setRemarks(row.getCell(9).toString().substring(0, row.getCell(9).toString().indexOf('.')).trim());
//		                   }else{
//		                	   wb.setRemarks(row.getCell(9).toString().trim());
//		                   }
//	                   }
//	                    infos.add(wb);  
//	                }  
//	              
//	        } catch (Exception e) {  
//	            e.printStackTrace();  
//	        }  
//	        return infos;  
//	    }  	
//	    
}


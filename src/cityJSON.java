import java.io.*;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class cityJSON {

	public static void main(String[] args) {
//		String file = "E:\\GD_java\\EA103_javaclass\\workspace\\iZu_worksapce\\EA103G2\\WebContent\\WEB-INF\\data\\city.txt";
////				+ "\\WEB-INF\\data\\city.txt";
//		StringBuilder jsonStr = new StringBuilder();
//		String str = "";
//		try {
//			FileReader fr = new FileReader(file);
//			BufferedReader br = new BufferedReader(fr); 
//			while((str = br.readLine()) !=null) {
//				jsonStr.append(str);
//			}
////			System.out.println(jsonStr);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
//
////		String jsonStr = "";
//
//		// List to JSON
//		jsonStr = new JSONArray(bookList).toString(); //放有順序性的東西
//		System.out.println("List to JSON: " + jsonStr);
//		// JSON to List
//		Array cities = new LinkedList();
//		JSONArray jsonArray = new JSONArray(jsonStr);
//		for (int i = 0; i < jsonArray.length(); i++) {
//			JSONObject json_city = jsonArray.getJSONObject(i);
//			String book_name = json_book.getString("name");
//			double book_price = json_book.getDouble("price");
//			String book_author = json_book.getString("author");
//			Book book = new Book(book_name, book_price, book_author);
//			books.add(book);
//		}
//		for (Book book : books) {
//			book.show();
//		}
//		System.out.println();
//
//		// Object (with List) to JSON
//		//轉成一個大的JSON Object的物件, 裡面的List變成JSON array
//		jsonStr = new JSONObject(order).toString();
//		System.out.println("Object (with List) to JSON: " + jsonStr);
//		// JSON to Object (with List)
//		JSONObject orderObj = new JSONObject(jsonStr);
//		String orderId = orderObj.getString("orderId");
//		String customer = orderObj.getString("customer");
//		// Locale.ENGLISH could be needed if current locale != ENGLISH 
//		// pattern letters refers to SimpleDateFormat in Javadoc
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
//				"EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
//		Date date = simpleDateFormat.parse(orderObj.getString("date"));
//		JSONArray jsonArray_books = orderObj.getJSONArray("bookList");
//		List<Book> myBookList = new ArrayList<Book>();
//		for (int i = 0; i < jsonArray_books.length(); i++) {
//			JSONObject json_book = jsonArray_books.getJSONObject(i);
//			String bookName = json_book.getString("name");
//			double bookPrice = json_book.getDouble("price");
//			String bookAuthor = json_book.getString("author");
//			Book book = new Book(bookName, bookPrice, bookAuthor);
//			myBookList.add((book));
//		}
//		OrderMaster myOrder = new OrderMaster(orderId, customer, date, myBookList);
//		myOrder.show();

//		========================================================================================

//		String[] letter = { "A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M", "N", "P", "Q", "R", "S", "T",
//				"U", "V", "X", "Y", "W", "Z", "I", "O" };
//		String letter = "ABCDEFGHJKLMNPQRSTUVXYWZIO";
//		String tnt_id = "a226547663";
//
//		String tmp = String.valueOf(letter.indexOf(tnt_id.substring(0,1).toUpperCase()) + 10);
////		Long numOfid = Long.parseLong(tmp +tnt_id.substring(1));
//		String numOfid = tmp +tnt_id.substring(1);
//		System.out.println(numOfid);
//		int weighted = 0;
//		System.out.println(numOfid.indexOf(1));
//		for(int i = 1; i < 10; i++) {
//			weighted += numOfid.indexOf(i) * (10 - i);
////			System.out.println(numOfid.indexOf(i));
//		}
//		weighted += numOfid.indexOf(0) * 1;
////		System.out.println(weighted);
//		weighted = weighted % 10;
////		System.out.println(weighted);
//		if ( numOfid.indexOf(10) == 0 && weighted == 0) {
////			return true
//			System.out.println(true);
//		}else if ( (10-weighted) == Integer.parseInt(tnt_id.substring(9))  ) {
//			System.out.println(true);
//		}else 
//			System.out.println(false);
//		========================================================================================
//		String s = "A212499083";
//		String checkHead = "ABCDEFGHJKLMNPQRSTUVWXYZIO"; // 字母代號對照表
//		if (s.length() == 10) {
//			char[] c = s.toUpperCase().toCharArray(); // 建立 c 陣列，同時將s字串轉大寫後，轉成字元陣列放入 c 陣列
//			int[] ID = new int[c.length]; // 建立一個運算用的整數陣列，空間為 c 的字元個數
//			// 驗證首位字母是否合法 (該字元是否能在checkHead[]找到), 驗證第一位是否為 1 or 2 (1=男生, 2=女生)
//			if (checkHead.indexOf(c[0]) == -1 || (c[1] != '1' && c[1] != '2'))
//				System.out.println("格式不合法");
//			else {
//				int sum = 0;
//				ID[0] = checkHead.indexOf(c[0]) + 10; // 第一個英文字運算
//				sum += ID[0] / 10; // .. 將商數加總 sum += ID[0]/10
//				ID[0] %= 10; // .. 取餘數放回 ID[0] 以便之後的運算
//				for (int i = 1; i < 10; i++) // 將身分證後9碼轉成整數型態 (ASCII碼-48)
//					ID[i] = (int) c[i] - 48;
//				for (int i = 0; i < 9; i++) { // 代入公式:
//					ID[i] *= (9 - i); // 總和 sum += (ID[0])*9 + ID[1]*8 + ID[2]*7 + ... + ID[9]*1
//					sum += ID[i];
//				}
//				// 檢查(10-sum%10)是否相等於檢查碼，且 sum%10(餘數)為0時，檢查碼為0 => (10-sum%10)%10
//				if ((10 - sum % 10) % 10 == ID[9])
//					System.out.println("合法.");
//				else
//					System.out.println("不合法");
//			}
//		} else
//			System.out.println("長度不合法");
//		
//		========================================================================================

//		java.sql.Date sysdate = new java.sql.Date(System.currentTimeMillis());
//		System.out.println(sysdate);
//		java.sql.Date sysdate1 = new java.sql.Date(System.currentTimeMillis());
//		System.out.println(sysdate1);
//		System.out.println(sysdate==sysdate1);
//		
//		//格式化: 用java.text.DateFormat的子類別java.text.SimpleDateFormat
//		java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd"
//				+ "");
//		String str = df.format(sysdate);
//		String str1 = df.format(sysdate1);
//		System.out.println(str);
//		System.out.println(str1);
//		System.out.println(df.format(sysdate).equals(df.format(sysdate1)));
//		System.out.println(df.format(sysdate)==df.format(sysdate1));
//		========================================================================================

//		String tnt_email = "aaa.a_1@hotmail.com.te.55646";
//		String emailReg = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z]+$";
//		if (tnt_email == null || tnt_email.trim().length() == 0) {
//			System.out.println("電子信箱: 請勿空白");
//		} else if (!tnt_email.trim().matches(emailReg)) {
//			System.out.println("電子信箱錯誤");
//		} else if (tnt_email.trim().matches(emailReg)) {
//			System.out.println("good");
//		}

	}

}

package sqlgenerator;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

/**
 * csvファイルを読み込んでカラムをキーにするMapのListにするクラス　命名が間違ってる気がする
 * @author 北村美岬
 *
 */
public class CsvReader {
	
	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static List<String> readCsvLines(String fileName) {
//		Properties properties = new Properties();
//		String csvPath = properties.getProperty("CSV_PATH") + fileName;
		String csvPath = "C:\\ForDevelop\\Data\\sqlganarator\\csvfile\\" + fileName;

		List<String> lines;
		try {
			Path path = Path.of(csvPath);
			lines = Files.readAllLines(path, Charset.forName("Shift-JIS"));
		} catch (IOException e) {
			e.printStackTrace();
			// エラー
			return null;
		}
		return lines;
	}
	
	/**
	 * 
	 * @param fileName　ファイルネームとテーブル名は一致させない方が後々いい気がする
	 * @return
	 */
	public static List<EnumMap<StudentsList, String>> getCsvMapList(String fileName) {
		
		// csvファイルを1行ずつ取得したリストを作成する
		List<String> lines = readCsvLines(fileName + ".csv");
		// csvファイルの1行目はカラム名とする
		String[] columnNames = lines.get(0).split(",");
		lines.remove(0);

		List<EnumMap<StudentsList, String>> csvMapList = new ArrayList<EnumMap<StudentsList, String>>();
		// カラム名と対応したマップのリストを作成する
		try {
			for (String line : lines) {
				String[] data = line.split(",");
				EnumMap<StudentsList, String> em = new EnumMap<>(StudentsList.class);
				for (int i = 0; i < data.length; i++) {
					em.put(StudentsList.valueOf(columnNames[i]), data[i]);
				}
				csvMapList.add(em);
			}
		} catch (IllegalArgumentException e) {
			// エラー
			return null;
		}

		return csvMapList;
	}
}

package pg_ex01_3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class pg_ex01_3 {

	private static Scanner scanner;
	private static FileWriter fw;

	public static void main(String[] arg) throws IOException {
		System.out.println("英文を入力してください.");
		scanner = new Scanner(System.in);

		HashMap<String, Integer> termMap = new HashMap<String, Integer>();

		File file = new File("c:\\temp\\README.md");
		fw = new FileWriter(file, true);

		while (scanner.hasNext()) {
			String term = scanner.next();

			// 英数値チェック
			if (!term.matches("^[0-9a-zA-Z]+$")) {
				System.out.println("英文以外が入力されたため、処理を終了します");
				return;
			}

			term.toUpperCase();

			// 単語の出現回数を1増やす
			int count = 1;
			if (termMap.containsKey(term)) {
				count += termMap.get(term);
			}
			termMap.put(term, count);
		}

		// ファイルへの出力
		Iterator<String> iterator = termMap.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Integer value = termMap.get(key);
			fw.write(key + value);
			fw.close();

		}

	}

}

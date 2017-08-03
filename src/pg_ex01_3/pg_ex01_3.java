package pg_ex01_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class pg_ex01_3 {

	private static Scanner scanner;
	private static BufferedWriter pw;

	public static void main(String[] arg) throws IOException {
		System.out.println("英文を入力してください.");
		scanner = new Scanner(System.in);

		HashMap<String, Integer> termMap = new HashMap<String, Integer>();

		File file = new File("c:\\temp\\README.md");
		pw = new BufferedWriter(new FileWriter(file));

		while (scanner.hasNext()) {
			String term = scanner.next();

			// 英数値チェックaa
			if (!term.matches("^[0-9a-zA-Z]+$")) {
				System.out.println("英文以外が入力されたため、処理を終了します");
				return;
			}

			// 小文字変換
			term.toUpperCase();

			// 単語の出現回数数える
			int count = 1;
			if (termMap.containsKey(term)) {
				count += termMap.get(term);
			}
			termMap.put(term, count);
		}

		// ソート処理
		List<Entry<String, Integer>> entries = new ArrayList<Entry<String, Integer>>(termMap.entrySet());

		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {

			public int compare(Entry<String, Integer> ans1, Entry<String, Integer> ans2) {
				return ans2.getValue().compareTo(ans1.getValue());
			}
		});

		// ファイル出力
		for (Entry<String, Integer> e : entries) {
			pw.write(e.getKey() + " : " + e.getValue());
		}

		System.out.println("結果が出力されました");
		pw.close();

	}

}

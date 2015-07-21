package quizz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedOrder {

	private static AtomicInteger id = new AtomicInteger(0);

	static class OrderGenerater implements Runnable {
		private ConcurrentLinkedQueue<String> queue;
		private String name;

		public OrderGenerater(String name, ConcurrentLinkedQueue<String> queue) {
			this.name = name;
			this.queue = queue;
		}

		@Override
		public synchronized void run() {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date();
			NumberFormat numFormat = NumberFormat.getInstance();
			numFormat.setMinimumIntegerDigits(3);
			numFormat.setMaximumIntegerDigits(3);
			String s = dateFormat.format(date)
					+ numFormat.format(id.incrementAndGet());
			System.out.println(name + " " + s);
			queue.add(s);
		}

	}

	public static void writeFile(File file, ConcurrentLinkedQueue<String> queue)
			throws IOException, InterruptedException {
		FileWriter fwout = new FileWriter(file);
		while (!queue.isEmpty()) {
			String str = queue.poll();
			// System.out.println(str);
			fwout.write(str + "\r\n");
			fwout.flush();
		}
		fwout.close();
	}

	public static void main(String[] args) throws IOException,
			InterruptedException {

		// 创建文件夹及文件
		File dir = new File("d:\\JavaTraining");
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "1.txt");

		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
		// 创建订单号
		for (int i = 0; i < 30; i++) {
			new Thread(new OrderGenerater("Thread A", queue)).start();
			new Thread(new OrderGenerater("Thread B", queue)).start();
			new Thread(new OrderGenerater("Thread C", queue)).start();
		}

		// 写入文件
		Thread.sleep(100);
		writeFile(file, queue);
	}

}

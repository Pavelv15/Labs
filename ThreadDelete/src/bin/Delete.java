package bin;

import java.io.IOException;

public class Delete extends  Thread {
    public void run() {
        try {
            Process p = new ProcessBuilder("powershell.exe","/C", "Remove-Item E:\\Test\\*.*")
                    //.redirectOutput(ProcessBuilder.Redirect.to(new File("result.txt"))) Вывести вывод потока в файл  //ProcessBuilder.Redirect.INHERIT вывод в консоль
                    .start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


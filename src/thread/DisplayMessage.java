package thread;

/**
 * @Author: zzy
 * Date: 2018/11/12
 * Time: 16:11
 * Description:
 */
public class DisplayMessage implements Runnable {

   private String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(message);
        }
    }
}

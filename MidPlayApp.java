/*
 * いい加減にmidiちゃんとやりたくない?
*/

package midPlay;

import java.io.File;
import java.util.Scanner;

public class MidPlayApp{
    public static void main(String[] args) {

        MidPlay mp = new MidPlay();
        
        //--シーケンサ準備
        mp.prepare(false); //ここでfalseにすると、デフォルトシーケンサに接続しなくなる

        //--デバイス一覧を取得
        String[] dlist = mp.getDeviceList();
        for (String device : dlist) {
            System.out.println(device);
        }

        //--シーケンサにデバイスを充てる
        Scanner sc = new Scanner(System.in);
        int id = Integer.parseInt(sc.nextLine());
        sc.close();
        mp.setDevice(id);

        //--読み込み、再生
        // mp.load(new File("./midPlay/sound.mid"));
        // mp.play();

        //--midiファイルをwavに変換
        mp.convWav(new File("./midPlay/conv.wav"));
    }
}
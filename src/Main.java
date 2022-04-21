import javax.swing.*;

public class Main {

    static int gecerliSoruIndisi = 0;//Yeni soru alırken kullanmak için globalde tanımladım.
    static int dogruSayisi = 0, yanlisSayisi = 0;

    public static void main(String[] args) {
        //--------------------------------------------SORULAR-ŞIKLAR-CEVAPLAR----------------------------------------------------
        //TODO Tüm işlemlerin main de toplanması çok da mantıklı deil. Ben uğraşmak istemesemde bunları ayırabilirsiniz.
        String[] sorular = {
                "Bir Sebepten Dolayı Tek Kulağına Küpe Takan Osmanlı Padişahı Kimdir?",
                "Aspirinin Hammaddesi Nedir?",
                "Hangi İlimizde Demiryolu Yoktur?",
                "Hangi Ülkenin İki Tane Başkenti Vardır?",
                "Aşağıdaki Ülkelerden Hangisinin Nüfusu Daha Fazladır?"
        };
        String[][] secenekler = {
                {"Kanuni Sultan Süleyman", "Yavuz Sultan Selim", "Orhan Bey D-Fatih", "Sultan Selim", "II.Abdülhamit"},
                {"Söğüt ", "Köknar", "Kavak", "Meşe", "Gürgen"},
                {"Batman", "Kütahya", "Aydın ", "Muğla"},
                {"Güney Afrika", "Senegal", "El Salvador", "Venezuela", "Kamboçya"},
                {"İspanya", "Fransa", "İngiltere", "Almanya", "Türkiye"}
        };
        String[] dogruCevaplar = {
                "B", "A", "D", "A", "D"
        };
        //-----------------------------------------------------------ARAYüZ------------------------------------------------------
        JFrame frame = new JFrame();
        frame.setSize(800, 500);

        //------------------Arayüz Elemanları---------------------------
        JRadioButton aSecenegi = new JRadioButton(secenekler[0][0]);
        JRadioButton bSecenegi = new JRadioButton(secenekler[0][1]);
        JRadioButton cSecenegi = new JRadioButton(secenekler[0][2]);
        JRadioButton dSecenegi = new JRadioButton(secenekler[0][3]);
        JLabel soruMetni = new JLabel(sorular[0]);
        JButton sonrakiSoruButonu = new JButton("SONRAKİ");
        //-----------------------Konumlandırma---------------------------
        aSecenegi.setBounds(110, 150, 300, 25);
        bSecenegi.setBounds(110, 200, 300, 25);
        cSecenegi.setBounds(110, 250, 300, 25);
        dSecenegi.setBounds(110, 300, 300, 25);
        soruMetni.setBounds(100, 70, 750, 50);
        sonrakiSoruButonu.setBounds(650, 400, 120, 50);

        //--------------------Seçenekleri Gruplama-----------------------

        ButtonGroup secenekGrubu = new ButtonGroup();
        secenekGrubu.add(aSecenegi);
        secenekGrubu.add(bSecenegi);
        secenekGrubu.add(cSecenegi);
        secenekGrubu.add(dSecenegi);

        //--------------------Elemanları Ekleme--------------------------
        frame.add(aSecenegi);
        frame.add(bSecenegi);
        frame.add(cSecenegi);
        frame.add(dSecenegi);
        frame.add(soruMetni);
        frame.add(sonrakiSoruButonu);

        //--------------------Buton Fonksiyonu---------------------------
        sonrakiSoruButonu.addActionListener(e -> {

            if (aSecenegi.isSelected() || bSecenegi.isSelected() || cSecenegi.isSelected() || dSecenegi.isSelected()) {
                String secim = null;
                if (aSecenegi.isSelected()) secim = "A";
                else if (bSecenegi.isSelected()) secim = "B";
                else if (cSecenegi.isSelected()) secim = "C";
                else if (dSecenegi.isSelected()) secim = "D";
                if(secim != null) {
                    if (secim.equals(dogruCevaplar[gecerliSoruIndisi])) {
                        dogruSayisi++;
                        JOptionPane.showMessageDialog(null, "Doğru Bildin Yuppppppiiiii", "İşte Bu", JOptionPane.INFORMATION_MESSAGE);
                    } else if (!dogruCevaplar[gecerliSoruIndisi].equals(secim)) {
                        yanlisSayisi++;
                        JOptionPane.showMessageDialog(null, "Başaramadın ...\nNeyi başaramadım diyosan doğru seçenek " + dogruCevaplar[gecerliSoruIndisi] + " olacaktı. ", "Oldumu Şimdi...", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            gecerliSoruIndisi++;
            if (gecerliSoruIndisi == 4) {
                sonrakiSoruButonu.setText("BİTİR");
            } else if (gecerliSoruIndisi == 5) {
                JOptionPane.showMessageDialog(null, "Oyun Bitti.\nDoğru Sayısı : " + dogruSayisi + "\nYanlış Sayısı : " + yanlisSayisi);
                System.exit(0);
            }
            //TODO Ben uğraşmak istemiyorum fakat soru metni çok uzunsa ikiye bölünüp araya "\n" eklenip o şekilde soru metnine verilebilir.
            soruMetni.setText(sorular[gecerliSoruIndisi]);
            aSecenegi.setText(secenekler[gecerliSoruIndisi][0]);
            bSecenegi.setText(secenekler[gecerliSoruIndisi][1]);
            cSecenegi.setText(secenekler[gecerliSoruIndisi][2]);
            dSecenegi.setText(secenekler[gecerliSoruIndisi][3]);

        });
        frame.setLayout(null);
        frame.setVisible(true);
    }
}

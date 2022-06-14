package io;

import Models.Sanpham;

import java.io.*;
import java.util.ArrayList;

public class ReaderAndWriter {

    public void write (ArrayList<Sanpham> sanphams){
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\Thithuchanh\\src\\data\\sanpham.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Sanpham sp : sanphams) {
                bufferedWriter.write(sp.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList <Sanpham> read (){
        ArrayList <Sanpham> products = new ArrayList<>();
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\Thithuchanh\\src\\data\\sanpham.csv");


        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while (str != null){
                String [] arr = str.split(",");
                int IdSanPham = Integer.parseInt(arr[0]);
                String tenSanPham = arr[1];
                float giaSanPham = Float.parseFloat(arr[2]);
                int soLuongSanPham = Integer.parseInt(arr[3]);
                String moTaSanPham = arr[4];
                products.add(new Sanpham(IdSanPham, tenSanPham, giaSanPham, soLuongSanPham, moTaSanPham));
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}

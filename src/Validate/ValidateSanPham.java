package Validate;

import Models.Sanpham;

import java.util.ArrayList;
import java.util.Scanner;

public class ValidateSanPham {
    Scanner scanner = new Scanner(System.in);

    public int validateIdSanPham (ArrayList<Sanpham> sanphams){
        while (true){
            try {
                System.out.println("Nhập ID: ");
                int Id = Integer.parseInt(scanner.nextLine());
                if (getIndexSanPham(Id,sanphams) != -1 || Id < 0) throw new Exception();
                else return Id;
            } catch (Exception e) {
                System.out.println("Nhập không thành công, Vui lòng nhập lại ID! ");
            }
        }
    }

    public int getIndexSanPham (int Id, ArrayList <Sanpham> sanphams){
        for (int i = 0; i < sanphams.size(); i++) {
            if (sanphams.get(i).getIdSanPham() == Id)
                return i;
        }
        return -1;
    }

    public String valiDateTenSanPham (){
        while (true){
            System.out.println("Nhập tên sản phẩm: ");
            String tenSanPham = scanner.nextLine();
            if ("".equals(tenSanPham)) {
                System.out.println("Tên không được để trống, vui lòng nhập lại");
                continue;
            } else
                return tenSanPham;
        }
    }

    public float valiDateGiaSanPham (){
        while (true){
            try {
                System.out.println("Nhập giá sản phẩm: ");
                Float giaSanPham = Float.parseFloat(scanner.nextLine());
                if (giaSanPham <= 0 ) throw new Exception();
                else return giaSanPham;
            } catch (Exception e) {
                System.out.println("Nhập không thành công, vui lòng nhập lại giá! ");
            }
        }
    }

    public int valiDateSoLuongSanPham (){
        while (true){
            try {
                System.out.println("Nhập số lượng: ");
                int soLuongSanPham = Integer.parseInt(scanner.nextLine());
                if (soLuongSanPham < 0) throw new Exception();
                else return soLuongSanPham;
            }catch (Exception e) {
                System.out.println("Nhập không thành công, vui lòng nhập lại! ");
            }
        }
    }
}

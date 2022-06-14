package Sort;

import Models.Sanpham;

import java.util.Comparator;

public class SapXepSanPham implements Comparator<Sanpham> {
    @Override
    public int compare(Sanpham o1, Sanpham o2) {
        if (o1.getGiaSanPham() > o2.getGiaSanPham()) return 1;
        else return -1;
    }
}

package algorithms_module3_hw;

import java.util.Comparator;
import java.util.List;

public class Collections {

    // static int binarySearch(List> list, T key)
    public static <T extends Comparable<? super T>> int binarySearch(List<T> list, T key) {
        return binarySearch(list, key, Comparator.naturalOrder());
    }

    //  static int binarySearch(List list, T key, Comparator c)
    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        int fromIndex = 0;
        int toIndex = list.size();
        while (fromIndex < toIndex) {
            int mid = (fromIndex + toIndex) >>> 1;
            int cmp = c.compare(list.get(mid), key);
            if (cmp < 0)
                fromIndex = mid + 1;
            else if (cmp > 0)
                toIndex = mid;
            else
                return mid; // ключ найден
        }
        return -(fromIndex + 1); // ключ не найден
    }
}

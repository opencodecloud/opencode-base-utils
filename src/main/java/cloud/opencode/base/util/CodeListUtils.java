package cloud.opencode.base.util;

import java.text.Collator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * @author Jon So,
 * e-mail: ijonso123@gmail.com
 * url: <a href="https://jon.wiki">Jon's blog</a>
 * url: <a href="https://github.com/opencodecloud">project github</a>
 * @version v1.0.0
 */
public final class CodeListUtils {

    private CodeListUtils(){}
    /**
     * check list1 and list2 has equal
     *
     * @param list1 List
     * @param list2 Lsit
     * @return boolean
     */
    public static boolean hasEqual(List<Integer> list1, List<Integer> list2) {
        List<Integer> collect1 = list1.stream().sorted(Comparator.comparing(a -> a)).collect(Collectors.toList());
        List<Integer> collect2 = list2.stream().sorted(Comparator.comparing(a -> a)).collect(Collectors.toList());
        return collect1.equals(collect2);
    }

    /**
     * list sort
     *
     * @param list      list
     * @param isAsc     true=a false=desc
     * @param isChinese true=chinese
     * @return list
     */
    public static List<String> sortList(List<String> list, boolean isAsc, boolean isChinese) {
        if (isChinese) {
            if (isAsc) {
                return list.stream()
                        .sorted((s1, s2) -> Collator.getInstance(Locale.CHINESE).compare(s1, s2))
                        .collect(Collectors.toList());
            } else {
                return list.stream()
                        .sorted((s1, s2) -> Collator.getInstance(Locale.CHINESE).reversed().compare(s1, s2))
                        .collect(Collectors.toList());
            }
        } else {
            return list.stream().sorted(Comparator.comparing(String::toString).reversed()).collect(Collectors.toList());
        }
    }
}

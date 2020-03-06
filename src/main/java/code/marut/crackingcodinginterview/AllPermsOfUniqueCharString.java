package code.marut.crackingcodinginterview;

import java.util.ArrayList;
import java.util.List;

public class AllPermsOfUniqueCharString {


    public static void main(String[] args) {
        String str = "abcd";
        List<char[]> allPerms = perms(str);

        for (char[] c : allPerms) {
            System.out.println(String.copyValueOf(c));
        }
        System.out.println("LENGTH #" + allPerms.size());
        final List<String> perms = new Perm2().perms(str);
        System.out.println("Second method LENGTH #" + perms.size());
        for (String p:perms){
            System.out.println(p);
        }
    }

    public static List<char[]> perms(String s) {
        char[] inputChars = s.toCharArray();
        return perms(inputChars, inputChars.length - 1);
    }

    public static List<char[]> perms(char[] inputChars, int index) {
        if (index == 0) {
            List<char[]> allPerms = new ArrayList<>();
            allPerms.add(new char[]{inputChars[index]});
            return allPerms;
        } else {
            return updatePerms(perms(inputChars, index - 1), inputChars[index]);
        }
    }

    public static List<char[]> updatePerms(List<char[]> currPerms, char addition) {
        List<char[]> allPerms = new ArrayList<>();
        for (char[] set : currPerms) {
            int i = 0;
            while (i <= set.length) {
                char[] build = new char[set.length + 1];
                int buildIndex = 0;
                for (int setIndex = 0; setIndex < set.length; setIndex++) {
                    if (setIndex == i) {
                        build[buildIndex++] = addition;
                    }
                    build[buildIndex++] = set[setIndex];
                }
                if (i == set.length) {
                    build[buildIndex] = addition;
                }
                allPerms.add(build);
                i++;
            }
        }


        return allPerms;
    }

    private static class Perm2 {
        public List<String> perms(final String input) {
            return perms(input, input.length() - 1);
        }

        private List<String> perms(final String input, int index) {
            if (index == 0) {
                final List<String> permsList = new ArrayList<>();
                permsList.add(input.substring(0, 1));
                return permsList;
            } else {
                return updatePerms(perms(input, index - 1), input.charAt(index));
            }
        }

        private List<String> updatePerms(List<String> currentPerms, final char addition) {
            List<String> allPerms = new ArrayList<>();
            for (String current : currentPerms) {
                for (int i = 0; i <= current.length(); i++) {
                    allPerms.add(getPerm(current, i, addition));
                }
            }
            return allPerms;
        }

        private String getPerm(final String input, int index, char addition) {
            if (index == 0) {
                return addition + input;
            }
            if (index == input.length()) {
                return input + addition;
            }
            return input.substring(0, index) + addition + input.substring(index);
        }
    }
}

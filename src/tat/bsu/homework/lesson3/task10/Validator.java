package tat.bsu.homework.lesson3.task10;

import sun.net.util.IPAddressUtil;

/**
 * Validate ip address.
 *
 * @author Eugeny Titenkov
 */
public class Validator {
    /**
     * Validate all ip addresses in array.
     *
     * @param ipAddresses - array, witch contains ip addresses.
     * @return true if all line in array are ip addresses, else false.
     */
    public static boolean validateIpAddresses(String[] ipAddresses) {
        for (String ipAddress : ipAddresses) {
            if (!IPAddressUtil.isIPv4LiteralAddress(ipAddress)) {
                return false;
            }
        }
        return true;
    }

}

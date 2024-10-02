package com.example.projekt.application.service.numberValidator;

import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.lookups.v1.PhoneNumber;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PhoneNumberValidator {
    // Twilio Account SID, Auth Token
    public static final String ACCOUNT_SID = "...";
    public static final String AUTH_TOKEN = "...";

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }


    private static class CountryInfo {
        String shortName;
        int minLength;
        int maxLength;

        CountryInfo(String shortName, int minLength, int maxLength) {
            this.shortName = shortName;
            this.minLength = minLength;
            this.maxLength = maxLength;
        }
    }

    private static final Map<String, CountryInfo> countryCodes = new HashMap<>();

    static {
        countryCodes.put("44", new CountryInfo("UK", 10, 10));       // United Kingdom
        countryCodes.put("33", new CountryInfo("FR", 9, 9));         // France
        countryCodes.put("49", new CountryInfo("DE", 8, 11));        // Germany
        countryCodes.put("39", new CountryInfo("IT", 10, 10));       // Italy
        countryCodes.put("34", new CountryInfo("ES", 9, 9));         // Spain
        countryCodes.put("31", new CountryInfo("NL", 9, 10));        // Netherlands
        countryCodes.put("41", new CountryInfo("CH", 9, 9));         // Switzerland
        countryCodes.put("46", new CountryInfo("SE", 7, 13));        // Sweden
        countryCodes.put("358", new CountryInfo("FI", 8, 12));       // Finland
        countryCodes.put("47", new CountryInfo("NO", 8, 8));         // Norway
        countryCodes.put("45", new CountryInfo("DK", 8, 8));         // Denmark
        countryCodes.put("353", new CountryInfo("IE", 9, 9));        // Ireland
        countryCodes.put("351", new CountryInfo("PT", 9, 9));        // Portugal
        countryCodes.put("371", new CountryInfo("LV", 8, 8));        // Latvia
        countryCodes.put("370", new CountryInfo("LT", 8, 8));        // Lithuania
        countryCodes.put("372", new CountryInfo("EE", 7, 8));        // Estonia
        countryCodes.put("420", new CountryInfo("CZ", 9, 9));        // Czech Republic
        countryCodes.put("421", new CountryInfo("SK", 9, 9));        // Slovakia
        countryCodes.put("48", new CountryInfo("PL", 9, 9));         // Poland
        countryCodes.put("36", new CountryInfo("HU", 8, 9));         // Hungary
        countryCodes.put("385", new CountryInfo("HR", 8, 12));       // Croatia
        countryCodes.put("386", new CountryInfo("SI", 8, 8));        // Slovenia
        countryCodes.put("382", new CountryInfo("ME", 8, 8));        // Montenegro
        countryCodes.put("381", new CountryInfo("RS", 8, 9));        // Serbia
        countryCodes.put("359", new CountryInfo("BG", 8, 9));        // Bulgaria
        countryCodes.put("377", new CountryInfo("MC", 8, 9));        // Monaco
        countryCodes.put("378", new CountryInfo("SM", 10, 10));      // San Marino
        countryCodes.put("40", new CountryInfo("RO", 9, 9));         // Romania
        countryCodes.put("373", new CountryInfo("MD", 8, 8));        // Moldova
        countryCodes.put("380", new CountryInfo("UA", 9, 9));        // Ukraine
        countryCodes.put("7", new CountryInfo("RU", 10, 10));        // Russia
        countryCodes.put("43", new CountryInfo("AT", 10, 11));       // Austria
        countryCodes.put("375", new CountryInfo("BY", 9, 9));        // Belarus
        countryCodes.put("387", new CountryInfo("BA", 8, 9));        // Bosnia and Herzegovina
        countryCodes.put("357", new CountryInfo("CY", 8, 8));        // Cyprus
        countryCodes.put("30", new CountryInfo("GR", 10, 10));       // Greece
        countryCodes.put("354", new CountryInfo("IS", 7, 7));        // Iceland
        countryCodes.put("423", new CountryInfo("LI", 7, 7));        // Liechtenstein
        countryCodes.put("356", new CountryInfo("MT", 8, 8));        // Malta
        countryCodes.put("376", new CountryInfo("AD", 6, 9));        // Andorra
        countryCodes.put("383", new CountryInfo("XK", 8, 8));        // Kosovo
        countryCodes.put("352", new CountryInfo("LU", 9, 11));       // Luxembourg
        countryCodes.put("389", new CountryInfo("MK", 8, 9));        // North Macedonia
        countryCodes.put("355", new CountryInfo("AL", 9, 9));        // Albania
        countryCodes.put("374", new CountryInfo("AM", 8, 8));        // Armenia
        countryCodes.put("995", new CountryInfo("GE", 9, 9));        // Georgia
        countryCodes.put("994", new CountryInfo("AZ", 9, 9));        // Azerbaijan
        countryCodes.put("90", new CountryInfo("TR", 10, 10));       // Turkey
        countryCodes.put("1", new CountryInfo("US", 10, 10));        // United States
        countryCodes.put("971", new CountryInfo("AE", 9, 9));        // United Arab Emirates
        countryCodes.put("86", new CountryInfo("CN", 11, 11));       // China
        countryCodes.put("91", new CountryInfo("IN", 10, 10));       // India
        countryCodes.put("81", new CountryInfo("JP", 10, 11));       // Japan
        countryCodes.put("55", new CountryInfo("BR", 10, 11));       // Brazil
        countryCodes.put("27", new CountryInfo("ZA", 9, 9));         // South Africa
        countryCodes.put("61", new CountryInfo("AU", 9, 9));         // Australia
        countryCodes.put("82", new CountryInfo("KR", 9, 11));        // South Korea
        countryCodes.put("52", new CountryInfo("MX", 10, 10));       // Mexico
        countryCodes.put("62", new CountryInfo("ID", 9, 12));        // Indonesia
        countryCodes.put("234", new CountryInfo("NG", 7, 8));        // Nigeria
        countryCodes.put("94", new CountryInfo("LK", 9, 9));         // Sri Lanka
        countryCodes.put("66", new CountryInfo("TH", 9, 10));        // Thailand
        countryCodes.put("60", new CountryInfo("MY", 9, 10));        // Malaysia
        countryCodes.put("63", new CountryInfo("PH", 10, 10));       // Philippines
        countryCodes.put("65", new CountryInfo("SG", 8, 8));         // Singapore
        countryCodes.put("84", new CountryInfo("VN", 9, 10));        // Vietnam
        countryCodes.put("95", new CountryInfo("MM", 7, 9));         // Myanmar
        countryCodes.put("92", new CountryInfo("PK", 9, 9));         // Pakistan
        countryCodes.put("64", new CountryInfo("NZ", 9, 9));         // New Zealand
        countryCodes.put("32", new CountryInfo("BE", 9, 9));         // Belgium


    }


    public static String validateAndFormatPhoneNumber(String phoneNumber) {
        String digitsOnly = phoneNumber.replaceAll("\\D", "");
        String trimmedNumber = removeLeadingZeros(digitsOnly);

        if (trimmedNumber.length() == 9 && !trimmedNumber.startsWith("376")) {
            if (isValidPolishNumber(trimmedNumber)) {
                return "+48" + trimmedNumber + " (PL)";
            } else {
                return "Invalid Polish phone number";
            }
        }

        for (Map.Entry<String, CountryInfo> entry : countryCodes.entrySet()) {
            String countryCode = entry.getKey();
            CountryInfo countryInfo = entry.getValue();

            if (trimmedNumber.startsWith(countryCode)) {
                String numberWithoutCode = trimmedNumber.substring(countryCode.length());
                String formattedNumber = "+" + countryCode + numberWithoutCode;
                // Twilio Lookup API
                if (!isNumberValidWithTwilio(formattedNumber)) {
                    return "Invalid phone number according to Twilio";
                }
                if (numberWithoutCode.length() >= countryInfo.minLength && numberWithoutCode.length() <= countryInfo.maxLength) {

                    switch (countryCode) {
                        case "48":
                            if (isValidPolishNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);
                            }
                            break;//Poland

                        case "44":
                            if (isValidUKNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;//UK
                        case "33":
                            if (isValidFrenchNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;
                        case "49":
                            if (isValidGermanNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Germany
                        case "39":
                            if (isValidItalianNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Italy
                        case "34":
                            if (isValidSpanishNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Spain
                        case "31":
                            if (isValidNetherlandsNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Netherlands
                        case "41":
                            if (isValidSwissNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;// Switzerland
                        case "46":
                            if (isValidSwedishNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Sweden
                        case "358":
                            if (isValidFinnishNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Finland
                        case "47":
                            if (isValidNorwegianNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Norway
                        case "45":
                            if (isValidDenmarkNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Denmark
                        case "353":
                            if (isValidIrelandNumber(numberWithoutCode)) {
                                return "+" + countryCode + numberWithoutCode + " (" + countryInfo.shortName + ")";
                            }
                            break; // Ireland
                        case "351":
                            if (isValidPortugalNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);
                               // return "+" + countryCode + numberWithoutCode + " (" + countryInfo.shortName + ")";
                            }
                            break; // Portugal
                        case "371":
                            if (isValidLatviaNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Latvia
                        case "370":
                            if (isValidLithuaniaNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);
                               // return "+" + countryCode + numberWithoutCode + " (" + countryInfo.shortName + ")";
                            } // Lithuania
                        case "372":
                            if (isValidEstonianNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;// Estonia
                        case "420":
                            if (isValidCzechiaNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Czech Republic
                        case "421":
                            if (isValidSlovakianNumber(numberWithoutCode)) {
                                return "+" + countryCode + numberWithoutCode + " (" + countryInfo.shortName + ")";
                            }
                            break; // Slovakia
                        case "36":
                            if (isValidHungarianNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;  // Hungary
                        case "385":
                            if (isValidCroatiaNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;  // Croatia
                        case "386":
                            if (isValidSloveniaNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;  // Slovenia
                        case "382":
                            if (isValidMontenegroNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;  // Montenegro
                        case "381":
                            if (isValidSerbianNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;  // Serbia
                        case "359":
                            if (isValidBulgarianNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);
                               // return "+" + countryCode + numberWithoutCode + " (" + countryInfo.shortName + ")";
                            }
                            break;  // Bulgaria
                        case "377":
                            if (isValidMonacoNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;   // Monaco
                        case "378":
                            if (isValidSanMarinoNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // San Marino
                        case "40":
                            if (isValidRomanianNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;// Romania
                        case "373":
                            if (isValidMoldovaNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Moldova
                        case "380":
                            if (isValidUkrainianNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;  // Ukraine
                        case "7":
                            if (isValidRussianNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Russia
                        case "43":
                            if (isValidAustrianNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;// Austria
                        case "375":
                            if (isValidBelarusNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;  // Belarus
                        case "387":
                            if (isValidBosniaAndHerzegovinaNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Bosnia and Herzegovina
                        case "357":
                            if (isValidCyprusNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;// Cyprus
                        case "30":
                            if (isValidGreekNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Greece
                        case "354":
                            if (isValidIcelandNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;// Iceland
                        case "423":
                            if (isValidLiechtensteinNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;// Liechtenstein
                        case "356":
                            if (isValidMaltaNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Malta
                        case "376":
                            if (isValidAndorraNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Andorra
                        case "383":
                            if (isValidKosovoNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Kosovo
                        case "352":
                            if (isValidLuxembourgNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;// Luxembourg
                        case "389":
                            if (isValidNorthMacedoniaNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // North Macedonia
                        case "355":
                            if (isValidAlbaniaNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Albania
                        case "374":
                            if (isValidArmeniaNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Armenia
                        case "995":
                            if (isValidGeorgiaNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;// Georgia
                        case "994":
                            if (isValidAzerbaijanNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;// Azerbaijan
                        case "90":
                            if (isValidTurkeyNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break;// Turkey
                        case "32":
                            if (isValidBelgiumNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // Belgium
                        case "1":
                            if (isValidUSNumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            // USA
                        case "971":
                            if (isValidUAENumber(numberWithoutCode)) {
                                return formatNumber(countryCode, numberWithoutCode, countryInfo);

                            }
                            break; // United Arab Emirates
                        case "86", "91", "81", "55", "27", "61", "82", "52", "62", "234", "94", "66", "60", "63", "65", "84", "95", "92", "64":
                            return formatNumber(countryCode, numberWithoutCode, countryInfo);

                        //China India Japan Brazil South Africa Australia South Korea Mexico Indonesia Nigeria
                        // Sri Lanka Thailand Malaysia Philippines Singapore Vietnam Myanmar Pakistan New Zealand

                        default:
                            return "Invalid phone number";

                    }

                }
            }
        }

        return "Invalid phone number";
    }
    private static boolean isNumberValidWithTwilio(String formattedNumber) {
        try {
            PhoneNumber number = PhoneNumber.fetcher(new com.twilio.type.PhoneNumber(formattedNumber)).fetch();
            return number != null;
        }  catch (ApiException e) {
            System.out.println("Number not found by Twilio API: " + e.getMessage());
            return false;
        }
    }

    private static String formatNumber(String countryCode, String numberWithoutCode, CountryInfo countryInfo) {
        return "+" + countryCode + numberWithoutCode + " (" + countryInfo.shortName + ")";
    }


    private static String removeLeadingZeros(String number) {
        return number.replaceFirst("^0+(?!$)", "");
    }

    private static boolean isValidPolishNumber(String number) {
        return number.matches("^[4-9]\\d{8}|212\\d{6}$");
    }//regula walidacyjna z firmy Orange

    private static boolean isValidRomanianNumber(String number) {
        return number.matches("^(71\\d{7}|7[2345]\\d{7}|76\\d{7}|77\\d{7}|78\\d{7})$");
    }//regula walidacyjna z https://www.ase-bucharest.esn.ro/mobile-networks

    private static boolean isValidUkrainianNumber(String number) {
        return number.matches("^([3456789])\\d{8}$");
    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Ukraine

    private static boolean isValidUAENumber(String number) {
        return number.matches("^5[02456]\\d{7}$");
    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_the_United_Arab_Emirates

    private static boolean isValidUSNumber(String number) {
        return number.matches("^[2-9]\\d{2}[2-9]\\d{2}\\d{4}$");
    }//regula walidacyjna z https://www.nationalnanpa.com/

    private static boolean isValidUKNumber(String number) {
        return number.matches("^7[1-9]\\d{8}$");
    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_the_United_Kingdom

    private static boolean isValidGermanNumber(String number) {
        return number.matches("^(15\\{8,9}|16\\d{8,9}|17\\d{8,9})$");
    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Germany

    private static boolean isValidFrenchNumber(String number) {
        return number.matches("^[67]\\d{8}$");
    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_France

    private static boolean isValidSpanishNumber(String number) {
        return number.matches("^[67][1-9]\\d{7}$");
    }//regula walidacyjna https://en.wikipedia.org/wiki/Telephone_numbers_in_Spain

    private static boolean isValidItalianNumber(String number) {
        return number.matches("^3\\d{9,10}$");
    }//regula walidacyjna https://en.wikipedia.org/wiki/Telephone_numbers_in_Italy

    private static boolean isValidNetherlandsNumber(String number) {
        return number.matches("^6\\d{8}$");
    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_the_Netherlands

    private static boolean isValidSwedishNumber(String number) {
        return number.matches("^(\\d{1,3})?[1-9]\\d{6,7}$");
    } //regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Sweden

    private static boolean isValidRussianNumber(String number) {
        return number.matches("^9\\d{9}$");
    }//regula walidaycjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Russia

    private static boolean isValidBelgiumNumber(String number) {
        return number.matches("^4\\d{8}$");
    } //regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Belgium

    private static boolean isValidCzechiaNumber(String number) {
        return number.matches("^(60[1-6]|70[2-4]|7[3-9]\\d|77[0-6]|77[89]|79[0-4]|79[7-9])\\d{6}$");

    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_the_Czech_Republic

    private static boolean isValidGreekNumber(String number) {
        return number.matches("^(69\\d{8})$");

    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Greece

    private static boolean isValidPortugalNumber(String number) {
        return number.matches("^(9\\d{8})$");

    } //regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Portugal


    private static boolean isValidHungarianNumber(String number) {
        return number.matches("^(20|30|31|70)\\d{7}$");

    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Hungary#:~:text=Making%20calls%20within%20and%20from%20Hungary,-Calls%20within%20local&text=For%20example%2C%20a%20call%20from,%3A%20%2B36%201%20234%205678.

    private static boolean isValidBelarusNumber(String number) {
        return number.matches("^(25|29|33|44)\\d{7}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Belarus

    private static boolean isValidAustrianNumber(String number) {
        return number.matches("(6|66|67|68|69)\\d{7}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Austria

    private static boolean isValidSerbianNumber(String number) {
        return number.matches("^(60|61|62|63|64|65|66|677|678|69)\\d{6,8}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Serbia

    private static boolean isValidSwissNumber(String number) {
        return number.matches("^(7[0-9])\\d{7}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Switzerland

    private static boolean isValidBulgarianNumber(String number) {
        return number.matches("^(87|88|89)\\d{7}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Bulgaria

    private static boolean isValidDenmarkNumber(String number) {
        return number.matches("^(20|21|22|23|24|25|26|27|28|29|30|31|40|41|42|49-11|50|51|52|53|54|55|60|61|71|81|91|92|93)\\d{6}$");
    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Denmark

    private static boolean isValidFinnishNumber(String number) {
        return number.matches("^(4\\d|457|50)\\d{3}\\d{2}\\d{2}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Finland#:~:text=Finnish%20mobile%20numbers%20start%20with,used%20for%20the%20subscriber%20number.

    private static boolean isValidSlovakianNumber(String number) {
        return number.matches("(9\\d)\\d{7}$");


    }//regula walidacyjna z https://www.itu.int/itudoc/itu-t/number/s/svk/71087_ww9.doc i https://en.wikipedia.org/wiki/Telephone_numbers_in_Slovakia#:~:text=Today%2C%20Slovakia%20uses%20a%20closed,a%207%2Ddigit%20subscriber%20number.

    private static boolean isValidNorwegianNumber(String number) {
        return number.matches("^(4\\d{2}\\d{2}\\d{3}|9\\d{2}\\d{2}\\d{3}|58\\d{10}|59\\d{6})$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Norway

    private static boolean isValidIrelandNumber(String number) {
        return number.matches("^(8[35679])\\d{7}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_the_Republic_of_Ireland

    private static boolean isValidCroatiaNumber(String number) {
        return number.matches("^(91|92|95|976|977|979|98|99)\\d{6,7}$");


    }//regula walidacyjna z https://www.itu.int/dms_pub/itu-t/oth/02/02/T02020000320003PDFE.pdf i https://en.wikipedia.org/wiki/Telephone_numbers_in_Croatia

    private static boolean isValidMoldovaNumber(String number) {
        return number.matches("^([67]\\d)\\d{6}$");


    }//regula walidacyjna z https://en.anrceti.md/node/81#:~:text=The%20NNP%20of%20the%20Republic%20of%20Moldova%20is%20an%20%E2%80%9Cclosed,or%20a%20short%20national%20number.

    private static boolean isValidBosniaAndHerzegovinaNumber(String number) {
        return number.matches("^(6[1-7])\\d{6}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Bosnia_and_Herzegovina

    private static boolean isValidAlbaniaNumber(String number) {
        return number.matches("^(6[2-9])\\d{7}$");


    }//regula walidacyjna z https://www.itu.int/dms_pub/itu-t/oth/02/02/T02020000020002PDFE.pdf

    private static boolean isValidLithuaniaNumber(String number) {
        return number.matches("^(6\\d{7})|(6[1-9])\\d{6}$");


    }//regula walidacyjna https://www.itu.int/dms_pub/itu-t/oth/02/02/T020200007C0001PDFE.pdf

    private static boolean isValidNorthMacedoniaNumber(String number) {
        return number.matches("^(7[0-9])\\d{6}$");


    }//regula walidacyjna https://en.wikipedia.org/wiki/Telephone_numbers_in_North_Macedonia

    private static boolean isValidSloveniaNumber(String number) {
        return number.matches("^(30|31|40|41|51|64|65|66|67|68|69|70|71)\\d{6}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Slovenia

    private static boolean isValidLatviaNumber(String number) {
        return number.matches("^(2\\d{7})|(2[1-9])\\d{6}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Latvia

    private static boolean isValidKosovoNumber(String number) {
        return number.matches("^(4[3-9])\\d{6}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Kosovo

    private static boolean isValidEstonianNumber(String number) {
        return number.matches("^(81|82|83|84|85|86|87|5\\d)\\d{6}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Estonia#:~:text=All%20calls%20inside%20Estonia%20are%20local%3B%20trunk%20codes%20are%20not%20used.&text=Landline%20phone%20numbers%20have%207,code%20for%20Estonia%20is%20%2B372.

    private static boolean isValidMontenegroNumber(String number) {
        return number.matches("^(6[036789]\\d{6})$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Montenegro

    private static boolean isValidLuxembourgNumber(String number) {
        return number.matches("^(6[25679]1\\d{6})$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Luxembourg

    private static boolean isValidMaltaNumber(String number) {
        return number.matches("^(79\\d{2}|9889|7210|99\\d{2}|9696|9897|921[01]|9231|77\\d{2}|981[1-3])\\d{4}$");


    }//regula walidacyjna z https://www.itu.int/dms_pub/itu-t/oth/02/02/T02020000840015PDFE.pdf

    private static boolean isValidIcelandNumber(String number) {
        return number.matches("^([678]\\d{6})$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Iceland

    private static boolean isValidLiechtensteinNumber(String number) {
        return number.matches("^([67]\\d{6})$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Liechtenstein

    private static boolean isValidAndorraNumber(String number) {
        return number.matches("^([346]\\d{5})$");


    }//regula walidacyjna https://simple.wikipedia.org/wiki/Telephone_numbers_in_Andorra#:~:text=Telephone%20numbers%20in%20Andorra%20are,its%20own%20country%20code%20%2B376.

    private static boolean isValidArmeniaNumber(String number) {
        return number.matches("^(91|99|96|43|33|97|55|95|41|44|66|50|93|94|77|98)\\d{6}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Armenia

    private static boolean isValidGeorgiaNumber(String number) {
        return number.matches("^(5\\d{8})|(5[0-9])\\d{7}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Georgia_(country)#:~:text=Telephone%20numbers%20in%20Georgia%20consist,7%20digits%20identify%20the%20subscriber.

    private static boolean isValidAzerbaijanNumber(String number) {
        return number.matches("^(50|51|55|70|77|99)\\d{7}$");


    }//regula walidacyjna z https://www.itu.int/oth/T0202.aspx?parent=T0202

    private static boolean isValidTurkeyNumber(String number) {
        return number.matches("^(501|505|506|507|530|531|532|533|534|535|536|537|538|539|540|541|542|543|544|545|546|547|548|549|551|552|553|554|555|559)\\d{7}$");


    }//regula walidacyjna z https://www.itu.int/dms_pub/itu-t/oth/02/02/T02020000D60002PDFE.pdf

    private static boolean isValidSanMarinoNumber(String number) {
        return number.matches("^(6[16]\\d{5,9}|0549\\d{6})$");


    }//regula walidacyjna z https://www.itu.int/dms_pub/itu-t/oth/02/02/T02020000B50001PDFE.pdf

    private static boolean isValidMonacoNumber(String number) {
        return number.matches("^(6\\d{8}|[34]\\d{7})$");


    }//regula walidacyjna https://www.itu.int/dms_pub/itu-t/oth/02/02/T020200008D0008PDFE.pdf


    private static boolean isValidCyprusNumber(String number) {
        return number.matches("^9\\d{7}$");


    }//regula walidacyjna z https://en.wikipedia.org/wiki/Telephone_numbers_in_Cyprus#:~:text=Telephone%20numbers%20in%20Cyprus%20follow,affixed%20to%20the%20phone%20number.


    public static void main(String[] args) {
        //String n1 = "0";
        String n1 = "1-800-555-5555";
        String n2 = "44 77 7946 0958";
        String n3 = "+33 1 45 67 89 00";
        String n4 = "49.30.1234567";
        String n5 = "+40 312 345 678";
        String n6 = "0039323456789";
        String n7 = "48,134,827,365";
        String n8 = "48666699675";
        String n9 = "40,756,030,583";
        String n10 = "48,156,030,583";
        String n11 = "0";
        String n12 = "351913897547";
        String n13 = "693887995";
        String n14 = "123456789";
        String n15 = "507,003,485";
        String n16 = "502-777-714";
        String n17 = "40,756,030,582";
        String n18 = "971568364503";
        String n19 = "9715683645036";
        String n20 = "111222334";
        String n21 = "447856183090";
        String n22 = "3519192213 39";
        String n23 = "4550634630";
        String n24 = "1 233 242 343 45";
        String n25 = "421905900430";
        String n26 = "31626670697";
        String n27 = "491602751137";
        String n28 = "353871363253";
        String n29 = "31657578101";
        String n30 = "37368200969";
        String n31 = "00420732125569";


        System.out.println(validateAndFormatPhoneNumber(n1));
        System.out.println(validateAndFormatPhoneNumber(n2));
        System.out.println(validateAndFormatPhoneNumber(n3));
        System.out.println(validateAndFormatPhoneNumber(n4));
        System.out.println(validateAndFormatPhoneNumber(n5));
        System.out.println(validateAndFormatPhoneNumber(n6));
        System.out.println(validateAndFormatPhoneNumber(n7));
        System.out.println(validateAndFormatPhoneNumber(n8));
        System.out.println(validateAndFormatPhoneNumber(n9));
        System.out.println(validateAndFormatPhoneNumber(n10));
        System.out.println(validateAndFormatPhoneNumber(n11));
        System.out.println(validateAndFormatPhoneNumber(n12));
        System.out.println(validateAndFormatPhoneNumber(n13));
        System.out.println(validateAndFormatPhoneNumber(n14));
        System.out.println(validateAndFormatPhoneNumber(n15));
        System.out.println(validateAndFormatPhoneNumber(n16));
        System.out.println(validateAndFormatPhoneNumber(n17));
        System.out.println(validateAndFormatPhoneNumber(n18));
        System.out.println(validateAndFormatPhoneNumber(n19));
        System.out.println(validateAndFormatPhoneNumber(n20));
        System.out.println(validateAndFormatPhoneNumber(n21));
        System.out.println(validateAndFormatPhoneNumber(n22));
        System.out.println(validateAndFormatPhoneNumber(n23));
        System.out.println(validateAndFormatPhoneNumber(n24));
        System.out.println(validateAndFormatPhoneNumber(n25));
        System.out.println(validateAndFormatPhoneNumber(n26));
        System.out.println(validateAndFormatPhoneNumber(n27));
        System.out.println(validateAndFormatPhoneNumber(n28));
        System.out.println(validateAndFormatPhoneNumber(n29));
        System.out.println(validateAndFormatPhoneNumber(n30));
        System.out.println(validateAndFormatPhoneNumber(n31));
    }
}

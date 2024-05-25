package org.example;

import lombok.*;

@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private String province;
    private String postalCode;
    private String country;

    public Address(int streetNo, String street, String city, String province, String postalCode, String country) {
        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
            this.country = country;
        } else {
            this.streetNo = 0;
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
            this.country = null;
        }
    }

    public int getStreetNo() {
        return streetNo;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    /**
     * Checks if a postcode is valid or not
     * @param postalCode the postal code to be validated.
     * @return if the postal code is valid according format if not return false
     */
    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null) return false;

        postalCode = postalCode.toUpperCase();
        if (postalCode.length() == 6) {
            for (int i = 0; i < 6; i++) {
                if (i % 2 == 0) {
                    if (!Character.isLetter(postalCode.charAt(i))) return false;
                } else {
                    if (!Character.isDigit(postalCode.charAt(i))) return false;
                }
            }
            return true;
        } else if (postalCode.length() == 7 && postalCode.charAt(3) == ' ') {
            for (int i = 0; i < 7; i++) {
                if (i == 3) continue;
                if (i % 2 == 0) {
                    if (!Character.isLetter(postalCode.charAt(i))) return false;
                } else {
                    if (!Character.isDigit(postalCode.charAt(i))) return false;
                }
            }
            return true;
        }
        return false;
    }
}


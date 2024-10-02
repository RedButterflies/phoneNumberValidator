package com.example.projekt;

import com.example.projekt.application.service.numberValidator.PhoneNumberValidator;
import com.twilio.Twilio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PhoneNumberValidatorTests {

    @Autowired
    private PhoneNumberValidator phoneNumberValidator;

    @Test
    public void test1() {
        assertEquals("+18005555555 (US)", phoneNumberValidator.validateAndFormatPhoneNumber("1-800-555-5555"));
    }

    @Test
    public void test2() {
        assertEquals("+447179460958 (UK)", phoneNumberValidator.validateAndFormatPhoneNumber("44 71 7946 0958"));
    }

    @Test
    public void test3() {
        assertEquals("+33645678900 (FR)", phoneNumberValidator.validateAndFormatPhoneNumber("+33 6 45 67 89 00"));
    }

    @Test
    public void test4() {
        assertEquals("Invalid phone number", phoneNumberValidator.validateAndFormatPhoneNumber("49.30.1234567"));
    }

    @Test
    public void test5() {
        assertEquals("+40712345678 (RO)", phoneNumberValidator.validateAndFormatPhoneNumber("+40 712 345 678"));
    }

    @Test
    public void test6() {
        assertEquals("Invalid phone number", phoneNumberValidator.validateAndFormatPhoneNumber("0039323456789"));
    }

    @Test
    public void test7() {
        assertEquals("+48734827365 (PL)", phoneNumberValidator.validateAndFormatPhoneNumber("48,734,827,365"));
    }

    @Test
    public void test8() {
        assertEquals("+48666699675 (PL)", phoneNumberValidator.validateAndFormatPhoneNumber("48666699675"));
    }

    @Test
    public void test9() {
        assertEquals("+40756030583 (RO)", phoneNumberValidator.validateAndFormatPhoneNumber("40,756,030,583"));
    }

    @Test
    public void test10() {
        assertEquals("Invalid phone number", phoneNumberValidator.validateAndFormatPhoneNumber("48,156,030,583"));
    }

    @Test
    public void test11() {
        assertEquals("Invalid phone number", phoneNumberValidator.validateAndFormatPhoneNumber("0"));
    }

    @Test
    public void test12() {
        assertEquals("+351913897547 (PT)", phoneNumberValidator.validateAndFormatPhoneNumber("351913897547"));
    }

    @Test
    public void test13() {
        assertEquals("+48693887995 (PL)", phoneNumberValidator.validateAndFormatPhoneNumber("693887995"));
    }

    @Test
    public void test13a() {
        assertEquals("Invalid Polish phone number", phoneNumberValidator.validateAndFormatPhoneNumber("123456789"));
    }
    @Test
    public void test14() {
        assertEquals("+491629741809 (DE)", phoneNumberValidator.validateAndFormatPhoneNumber("+49 162 9741809"));
    }

    @Test
    public void test15() {
        assertEquals("+34671234567 (ES)", phoneNumberValidator.validateAndFormatPhoneNumber("+34 6712.34.567."));
    }

    @Test
    public void test16() {
        assertEquals("Invalid phone number", phoneNumberValidator.validateAndFormatPhoneNumber("+39 06 1234 5678"));
    }

    @Test
    public void test17() {
        assertEquals("+41791234567 (CH)", phoneNumberValidator.validateAndFormatPhoneNumber("+41 79 123 45 67"));
    }

    @Test
    public void test18() {
        assertEquals("Invalid phone number", phoneNumberValidator.validateAndFormatPhoneNumber("353-1-234567"));
    }

    @Test
    public void test19() {
        assertEquals("+4551234567 (DK)", phoneNumberValidator.validateAndFormatPhoneNumber("+45 51-23.456.7"));
    }

    @Test
    public void test20() {
        assertEquals("+46701234567 (SE)", phoneNumberValidator.validateAndFormatPhoneNumber("+46 70 123 45 67"));
    }

    @Test
    public void test21() {
        assertEquals("+358501234567 (FI)", phoneNumberValidator.validateAndFormatPhoneNumber("+358 50 123 4567"));
    }

    @Test
    public void test22() {
        assertEquals("+4759456789 (NO)", phoneNumberValidator.validateAndFormatPhoneNumber("+47 59 45 67 89"));
    }

    @Test
    public void test23() {
        assertEquals("+38664012345 (SI)", phoneNumberValidator.validateAndFormatPhoneNumber("+3866.40123.4.5 "));
    }

    @Test
    public void test24() {
        assertEquals("+37121234567 (LV)", phoneNumberValidator.validateAndFormatPhoneNumber("+371 21 234 567"));
    }

    @Test
    public void test25() {
        assertEquals("+37061234567 (LT)", phoneNumberValidator.validateAndFormatPhoneNumber("+370 6 123 4567"));
    }

    @Test
    public void test26() {
        assertEquals("+420602345678 (CZ)", phoneNumberValidator.validateAndFormatPhoneNumber("+420 60 234 5678"));
    }

    @Test
    public void test27() {
        assertEquals("+421912345678 (SK)", phoneNumberValidator.validateAndFormatPhoneNumber("+421 91 234 5678"));
    }

    @Test
    public void test28() {
        assertEquals("Invalid phone number", phoneNumberValidator.validateAndFormatPhoneNumber("42 123 456"));
    }

    @Test
    public void test29() {
        assertEquals("+353871234567 (IE)", phoneNumberValidator.validateAndFormatPhoneNumber("+353 87 123 4567"));
    }

    @Test
    public void test30() {
        assertEquals("+351912345678 (PT)", phoneNumberValidator.validateAndFormatPhoneNumber("+351 91 234 5678"));
    }
    @Test
    public void test31() {
        assertEquals("+38166303366 (RS)", phoneNumberValidator.validateAndFormatPhoneNumber(" +381 66 303366"));
    }
    @Test
    public void testFinland() {
        assertEquals("+358453160442 (FI)", phoneNumberValidator.validateAndFormatPhoneNumber(" +358 45 3160442"));
    }
    @Test
    public void testIreland() {
        assertEquals("+353892059520 (IE)", phoneNumberValidator.validateAndFormatPhoneNumber("  +353 89 205 9520"));
    }
    @Test
    public void testMoldova() {
        assertEquals("+37376707071 (MD)", phoneNumberValidator.validateAndFormatPhoneNumber("  +373 767 07 071"));
    }
    @Test
    public void testBosniaHerzegovina() {
        assertEquals("+38761449413 (BA)", phoneNumberValidator.validateAndFormatPhoneNumber(" +387 61 449 413"));
    }

    @Test
    public void testAlbania() {
        assertEquals("+355675672221 (AL)", phoneNumberValidator.validateAndFormatPhoneNumber("+355 67 567 2221"));
    }

    @Test
    public void testLithuania() {
        assertEquals("+37069493900 (LT)", phoneNumberValidator.validateAndFormatPhoneNumber("+370 694 93900"));
    }

    @Test
    public void testNorthMacedonia() {
        assertEquals("+38976794776 (MK)", phoneNumberValidator.validateAndFormatPhoneNumber(" +389 76 794 776"));
    }

    @Test
    public void testLatvia() {
        assertEquals("+37127073986 (LV)", phoneNumberValidator.validateAndFormatPhoneNumber(" +371 27 073 986"));
    }

    @Test
    public void testKosovo() {
        assertEquals("+38349320810 (XK)", phoneNumberValidator.validateAndFormatPhoneNumber("  +383 49 320 810"));
    }

    @Test
    public void testEstonia() {
        assertEquals("+37256600345 (EE)", phoneNumberValidator.validateAndFormatPhoneNumber("+372 5660 0345"));
    }

    @Test
    public void testMontenegro() {
        assertEquals("+38269891227 (ME)", phoneNumberValidator.validateAndFormatPhoneNumber("382 69 891 227"));
    }

    @Test
    public void testLuxembourg() {
        assertEquals("+352621312649 (LU)", phoneNumberValidator.validateAndFormatPhoneNumber("+352621312649"));
    }

    @Test
    public void testMalta() {
        assertEquals("+35679391472 (MT)", phoneNumberValidator.validateAndFormatPhoneNumber("+356 7939 1472"));
    }
    @Test
    public void testIceland() {
        assertEquals("+3546550405 (IS)", phoneNumberValidator.validateAndFormatPhoneNumber("+3546550405"));
    }
    @Test
    public void testAndorra() {
        assertEquals("+376341181 (AD)", phoneNumberValidator.validateAndFormatPhoneNumber("+376 341 181"));
    }
    @Test
    public void testGeorgia() {
        assertEquals("+995579262372 (GE)", phoneNumberValidator.validateAndFormatPhoneNumber("+995 579 26 23 72"));
    }
    @Test
    public void testTurkey() {
        assertEquals("+905383316259 (TR)", phoneNumberValidator.validateAndFormatPhoneNumber("+90 538 331 62 59"));
    }

    @Test
    public void testVatican() {
        assertEquals("+905383316259 (TR)", phoneNumberValidator.validateAndFormatPhoneNumber("+90 538 331 62 59"));
    }

    @Test
    public void testSanMarino() {
        assertEquals("+3780549903662 (SM)", phoneNumberValidator.validateAndFormatPhoneNumber("378 0549 903662"));
    }

    @Test
    public void testMonaco() {
        assertEquals("+37737700779 (MC)", phoneNumberValidator.validateAndFormatPhoneNumber("37737 700779 "));
    }


}

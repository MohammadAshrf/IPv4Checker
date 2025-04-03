package com.example.ipv4checker

import org.junit.Assert.*
import org.junit.Test

class IPv4CheckerTest {

    val checker = IPv4Checker()

    @Test
    fun `when IPv4 address is valid then return true`() {
        assertTrue(checker.isValidIPv4("192.168.0.1"))
    }

    @Test
    fun `when IPv4 has less than 4 segments then return false`() {
        assertFalse(checker.isValidIPv4("192.168.1"))
    }

    @Test
    fun `when IPv4 has more than 4 segments then return false`() {
        assertFalse(checker.isValidIPv4("192.168.1.1.5"))
    }

    @Test
    fun `when IPv4 contains non-numeric value then return false`() {
        assertFalse(checker.isValidIPv4("192.abc.0.1"))
    }

    @Test
    fun `when IPv4 contains a number above 255 then return false`() {
        assertFalse(checker.isValidIPv4("300.1.2.3"))
    }

    @Test
    fun `when IPv4 segment is negative then return false`() {
        assertFalse(checker.isValidIPv4("-1.2.3.4"))
    }

    @Test
    fun `when IPv4 segment starts with leading zero then return false`() {
        assertFalse(checker.isValidIPv4("01.2.3.4"))
    }

    @Test
    fun `when IPv4 segments have multiple leading zeros then return false`() {
        assertFalse(checker.isValidIPv4("001.002.003.004"))
    }

    @Test
    fun `when IPv4 has empty segment then return false`() {
        assertFalse(checker.isValidIPv4("192..1.1"))
    }

    @Test
    fun `when IPv4 ends with a dot then return false`() {
        assertFalse(checker.isValidIPv4("192.168.1.1."))
    }

    @Test
    fun `when IPv4 has surrounding whitespace then return false`() {
        assertFalse(checker.isValidIPv4(" 192.168.1.1 "))
    }

    @Test
    fun `when IPv4 segment contains alphabetic characters then return false`() {
        assertFalse(checker.isValidIPv4("1a2.168.1.1"))
    }

    @Test
    fun `when IPv4 contains special characters then return false`() {
        assertFalse(checker.isValidIPv4("192.168.#.1"))
    }

    @Test
    fun `when IPv4 address is an empty string then return false`() {
        assertFalse(checker.isValidIPv4(""))
    }
}
package com.example.ipv4checker

class IPv4Checker {
    fun isValidIPv4(address: String): Boolean {
        if (address != address.trim()) return false
        if (address.startsWith(".") || address.endsWith(".")) return false

        val parts = address.split(".")
        if (parts.size != 4) return false

        for (part in parts) {
            if (!isValidSegment(part)) return false
        }

        return true
    }

    private fun isValidSegment(segment: String): Boolean {
        if (segment.isEmpty()) return false
        if (!segment.all { it.isDigit() }) return false
        if (segment.length > 1 && segment.startsWith('0')) return false
        val num = segment.toIntOrNull() ?: return false
        return num in 0..255
    }
}
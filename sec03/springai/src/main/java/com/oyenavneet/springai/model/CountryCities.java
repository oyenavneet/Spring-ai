package com.oyenavneet.springai.model;

import java.util.List;

public record CountryCities(
        String country,
        List<String> cities
) {
}

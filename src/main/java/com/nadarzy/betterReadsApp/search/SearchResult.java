package com.nadarzy.betterReadsApp.search;

import java.util.List;

/**
 * @author Julian Nadarzy on 17/11/2021
 */
public class SearchResult {
    private int numFound;
    private List<SearchResultBook> docs;

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public List<SearchResultBook> getDocs() {
        return docs;
    }

    public void setDocs(List<SearchResultBook> docs) {
        this.docs = docs;
    }
}

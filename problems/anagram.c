#include<stdio.h>
#include<string.h>
#include<assert.h>

int anagram(char *a, char *b) {
    int lena = strlen(a), lenb = strlen(b);
    if (lena != lenb) return 0;
    int counta[26], countb[26];
    memset(counta, 0, sizeof(counta));
    memset(countb, 0, sizeof(countb));
    for (int i=0; i<lena; ++i) {
        ++counta[a[i]-95];
        ++countb[b[i]-95];
    }
    for (int i=0; i<26; ++i)
        if (counta[i] != countb[i]) return 0;
    return 1;
}

int main() {
    assert(anagram("rat", "art"));
    assert(!anagram("rat", "arta"));
    assert(!anagram("boat", "toad"));
    assert(!anagram("boat", "notaboat"));
    printf("OK");
}

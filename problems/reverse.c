#include <stdio.h>
#include <string.h>

void reverse(char *str) {
}

int main() {
    char *str = "abcdef";
    printf("%s\n", str);
    char *right = str;
    char tmp;
    while (*right)
        ++right;
    --right;
    while (str<right) {
        tmp = *str;
        *str++ = *right;
        *right-- = tmp;
    }
    printf("%s\n", str);
    return 0;
}

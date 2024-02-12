#include<stdio.h>

int main() {
    int days;
    printf("enter days: ");
    scanf("%d", &days);
    int years, months, weeks;
    years = days/365;
    days %= 365;
    months = days/30;
    days %= 30;
    weeks = days/7;
    days %= 7;

    printf("years = %d\nmonths = %d\nweeks = %d\ndays = %d\n", years, months, weeks, days);
    return 0;
}
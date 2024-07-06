fun isLeap (year : int) =
    (year mod 4 = 0 andalso not (year mod 100 = 0)) orelse (year mod 400 = 0)

fun get_nth_int (xs : int list, n : int) =
    if n = 1
    then hd xs
    else get_nth_int(tl xs, n-1)

fun days_in_month (month : int) =
    let val days = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    in
        get_nth_int(days,month)
    end
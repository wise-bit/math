def checkPerfectNumber(num: int) -> bool:
    s = 0
    if num == 1: return False;
    for i in range(2, int(num**0.5)+1):
        if num % i == 0:
            s += i
            s += num//i
    return s+1 == num

print(checkPerfectNumber(8128))

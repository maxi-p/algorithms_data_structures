def distributeRanges(ranges):
    ranges = sorted(ranges)
    res = []
    i=0
    while i < len(ranges)-1:
        start, end = ranges[i]
        start_next, end_next = ranges[i+1]
        if (start >= start_next and start <= end_next) or (start_next >= start and start_next <= end):
            ranges[i+1] = [min(start, start_next), max(end, end_next)]
            ranges.pop(i)
        else:
            i += 1
    n = len(ranges)
    res = 1
    large = 10 ** 9 + 7
    for i in range(n, 0, -1):
        res *= i
        res = res % large

    return res if res > 1 else 0

if __name__ == '__main__':
    result = distributeRanges([[1,3], [2,5], [100, 106], [102, 1000]])
    print(result)
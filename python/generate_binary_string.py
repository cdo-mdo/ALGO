def generate_binary_strings(n):
    if n == 0:
        return [""]
    smaller_strings = generate_binary_strings(n - 1)
    result = []
    for s in smaller_strings:
        result.append(s + "0")
        result.append(s + "1")
    return result

length = 3
binary_strings = generate_binary_strings(length)
print(binary_strings)

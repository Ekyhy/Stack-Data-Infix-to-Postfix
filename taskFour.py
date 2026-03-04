def prec(c):
    if c == '^':
        return 3
    elif c == '/' or c == '*':
        return 2
    elif c == '+' or c == '-':
        return 1
    else:
        return -1

def isRightAssociative(c):
    return c == '^'

def infixToPostfix(s):
    st = []
    res = []

    for c in s:
        # Memalakukan pembacaan ke operand
        if c.isalnum():
            res.append(c)
            res.append(" ")

        # Jika '(', masukkan ke dalam stack
        elif c == '(':
            st.append('(')

        # Jika ')', hapus hingga menemui '('
        elif c == ')':
            while st and st[-1] != '(':
                res.append(st.pop())
            st.pop()

        # jika ada operator
        else:
            while st and st[-1] != '(' and \
                (prec(st[-1]) > prec(c) or (prec(st[-1]) == prec(c) \
                                            and not isRightAssociative(c))):
                res.append(st.pop())
            st.append(c)
            res.append(" ")


    while st:
        res.append(st.pop())

    return ''.join(res)

if __name__ == '__main__':
    exp = input("Masukkan Translate Infix: ")
    print("Infix: ",exp)
    print("Postfix: ",infixToPostfix(exp))
taxas = {
    'SP': 0.03,
    'RJ': 0.05,
    'MG': 0.07,
    'PR': 0.08,
    'ES': 0.09,
}


def calcularDesconto(valorCompra):
    if valorCompra >= 50000:
        desconto = 0.12
    elif valorCompra >= 20000:
        desconto = 0.1
    elif valorCompra >= 10000:
        desconto = 0.08
    elif valorCompra >= 1000:
        desconto = 0.05
    elif valorCompra >= 100:
        desconto = 0.03
    else:
        desconto = 0

    return valorCompra - (valorCompra * desconto)


def calcularValorFinal(quantidadeProduto, valorUnitarioProduto, imposto):
    valorInicial = quantidadeProduto * valorUnitarioProduto
    valorFinal = valorInicial + (valorInicial*imposto)
    return calcularDesconto(valorFinal)


def main():
    quantidadeProduto = float(input("qtdPrd: "))
    print (quantidadeProduto)

    valorUnitarioProduto = float(input("vlrPrd: "))
    print (valorUnitarioProduto)

    estado = (input("estado (SP, RJ, MG, PR ou ES): "))
    print (estado)

    valorFinal = calcularValorFinal(
        quantidadeProduto,
        valorUnitarioProduto,
        taxas[estado]
    )

    print("Valor da compra {0}".format(valorFinal))


main()

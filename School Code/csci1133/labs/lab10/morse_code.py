#Jacob Wittrig wittr049
#lab10
#morse_code.py

morse_dictionary={'A': '.-', 'B': '-...', 'C': '-.-.',
'D': '-..', 'E': '.', 'F': '..-.', 'G': '--.', 'H': '....',
'I': '..', 'J': '.---', 'K': '-.-', 'L': '.-..', 'M': '--',
'N': '-.', 'O': '---', 'P': '.--.', 'Q': '--.-', 'R': '.-.',
'S': '...', 'T': '-', 'U': '..-', 'V': '...-', 'W': '.--',
'X': '-..-', 'Y': '-.--', 'Z': '--..', ' ': '/'}

def morse(message):
    encoded=""
    for val in message:
        encoded+=(morse_dictionary[val])+" "
    return encoded
def main():
    print(morse("My TAs are amazing".upper()))

if __name__ == "__main__":
    main()

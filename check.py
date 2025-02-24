import os

# Список кодировок, которые будем проверять
ENCODINGS = ['utf-8', 'windows-1251', 'iso-8859-1', 'cp1252', 'ascii']

def find_text_files(directory):
    """Находит все текстовые файлы в указанной директории."""
    text_files = []
    for root, dirs, files in os.walk(directory):
        for file in files:
            if file.endswith(".java"):
                text_files.append(os.path.join(root, file))
    return text_files

def detect_encoding(file_path):
    """Пытается определить кодировку файла."""
    for encoding in ENCODINGS:
        try:
            with open(file_path, 'r', encoding=encoding) as f:
                f.read()  # Пытаемся прочитать файл
            return encoding  # Если удалось, возвращаем кодировку
        except UnicodeDecodeError:
            continue  # Если ошибка, пробуем следующую кодировку
    return "Неизвестная кодировка"  # Если ни одна кодировка не подошла

def main():
    directory = input("Введите путь к директории: ")
    text_files = find_text_files(directory)
    
    if not text_files:
        print("Текстовые файлы не найдены.")
        return
    
    for file in text_files:
        encoding = detect_encoding(file)
        print(f"Файл: {file}, Кодировка: {encoding}")

if __name__ == "__main__":
    main()

# 📊 XLSX Nth-Min Finder API

Простое REST API на **Spring Boot**, позволяющее находить **N-е минимальное число** в Excel-файле (.xlsx).  
API принимает путь к файлу и номер элемента, возвращает найденное значение в формате JSON.

---

## ⚙️ Требования

- **Java 17+**
- **Maven 3.8+**
- Excel-файл (.xlsx) с числовыми данными в первом столбце

---

## Шаги по запуску проекта

### Клонирование репозитория
```bash
git clone https://github.com/Nekitcus/ComfortSoft.git
cd ComfortSoft
```

### Сборка проекта
```bash
mvn clean package -DskipTests
```

Документация доступна:
```bash
http://localhost:8080/swagger-ui.html
```
Работоспособность эндпоинта можно проверить там же
## 🔹 BUG-001 : GET /test. Ошибка формата JSON в body ответа

### Серьезность: Critical

### Описание:

При десериализации JSON-ответов с помощью Jackson возникает ошибка.  
В результате выбрасывается исключение `JsonParseException`.
Значение ответа передаётся не в JSON, а как строка, где поля содержат табуляцию.
Также в поле "model" значение передаётся без кавычек, такой формат не поддерживается JSON,
так как не является каким-либо типом данных.

### Шаги для воспроизведения

1. Отправить запрс: GET http://localhost:4567/test

### Ожидаемый результат:

/// Так как в документаци не указана структура данных, нужно уточнить у аналитика/пм что должно быть.
В рамках тестового задания фиксирую то, что возвращает запрос, но в корректной форме.

```json
{
  "VPNUser": "vpnuser",
  "VPNVendor": "CheckPoint",
  "bios.manufacturer": "American Megatrends Inc.",
  "bios.releasedate": "2018-04-11 00:00:00 +0000 UTC",
  "bios.version": "F24",
  "crc": "3118122546",
  "debug": true,
  "domain": "",
  "fqdn": "EGOR-OFFICE",
  "hostid": "e0fbafc5-ce68-4896-9526-7b3a7ed0e8f1",
  "hostname": "EGOR-OFFICE",
  "hwuuid": "032E02B4-0499-0521-3A06-C40700080009",
  "innerHostName": "Egor-Office",
  "ip_1": "172.17.112.1/20",
  "ip_10": "fe80::c428:2e47:aeb6:751b/64",
  "ip_11": "169.254.233.132/16",
  "ip_12": "fe80::6835:866c:806a:e984/64",
  "ip_13": "10.102.37.150/30",
  "ip_14": "169.254.92.204/16",
  "ip_15": "fe80::7004:6d4a:f465:5ccc/64",
  "ip_16": "169.254.25.233/16",
  "ip_17": "fe80::553:764f:ac5:19e9/64",
  "ip_18": "192.168.147.1/24",
  "ip_19": "fe80::9906:551c:828d:7644/64",
  "ip_2": "fe80::7994:70f:463:8cfd/64",
  "ip_20": "192.168.37.1/24",
  "ip_21": "fe80::c593:bc2a:42a5:4f62/64",
  "ip_22": "127.0.0.1/8",
  "ip_23": "::1/128",
  "ip_3": "192.168.88.226/24",
  "ip_4": "fe80::6cf6:de2b:f16f:1bc3/64",
  "ip_5": "169.254.3.191/16",
  "ip_6": "fe80::6823:d6f2:3535:3bf/64",
  "ip_7": "192.168.56.1/24",
  "ip_8": "fe80::bc62:a2f7:6ce2:ed2a/64",
  "ip_9": "169.254.117.27/16",
  "maintenanceMode": "false",
  "manufacturer": "Gigabyte Technology Co., Ltd.",
  "model": "H110M-H",
  "os.arch": 64,
  "os.family": "windows",
  "os.platform": "Microsoft Windows 10 Pro",
  "os.version": "10.0.19044 Build 19044",
  "serverAddress": "http://sak-tst-srv1:1325",
  "servicetag": "Default string",
  "timezone": "+07",
  "type": null,
  "uptime": "2024-01-10 09:58:00 +0000 UTC",
  "useStandalone": true,
  "user_id": "S-1-5-18",
  "version": "2.11.51",
  "working_dir": "C:\\Program Files (x86)\\sakura"
}
```

### Фактический результат:

```
[Source: (String)"{ 
\u0009\u0009"VPNUser": "vpnuser",
\u0009\u0009"VPNVendor": "CheckPoint",
\u0009\u0009"bios.manufacturer": "American Megatrends Inc.",
\u0009\u0009"bios.releasedate": "2018-04-11 00:00:00 +0000 UTC",
\u0009\u0009"bios.version": "F24",
\u0009\u0009"crc": "3118122546",
\u0009\u0009"debug": true,
\u0009\u0009"domain": "",
\u0009\u0009"fqdn": "EGOR-OFFICE",
\u0009\u0009"hostid": "e0fbafc5-ce68-4896-9526-7b3a7ed0e8f1",
\u0009\u0009"hostname": "EGOR-OFFICE",
\u0009\u0009"hwuuid": "032E02B4-0499-0521-3A06-C40700080009",
\u0009\u0009"innerHostName": "Egor-Office",
\u0009\u0009"ip_1": "172.17.112.1/20",
\u0009\u0009"ip_10": "fe80::c428:2e47:aeb6:751"
[truncated 1264 chars]; line: 40, column: 17]
```

---

## 🔹 BUG-002: GET /users . Ошибка в названии поля "n oChangePassword"

### Серьезность: Trivial

### Описание:

В документации присутствует опечатка.
///Подобных опечаток несколько в разных запросах, не буду акцентировать внимание на них в рамках тестового задания

### Шаги для воспроизведения

1. Открыть описание GET /users в Сопроводительной документации. Раздел структура данных.

### Ожидаемый результат:

"noChangePassword"

### Фактический результат:

"n oChangePassword"

---

## 🔹 BUG-003: GET /v2/check. В ответе возвращает не корректную структуру данных

### Серьезность: Critical

### Описание:

Ответ запроса не соответсвует структуре данных описанной в Сопроводительной документации.
///В рамках тестового задания предположу, что ответ соответсвует первой версии запроса, что всё равно является багой)

### Шаги для воспроизведения

1. Отправить запрос GET http://localhost:4567/v2/check

### Ожидаемый результат:

```json
{
  "ruleResults": {
    "50767435": {
      "id": "05376357-4c95-11e9-914f-000c29bc93aa",
      "rule_type": "processlist",
      "name": "calc",
      "message": "Найден хотя бы один из следующих запрещенных процессов: Calculator.exe ",
      "command": "stop",
      "sessionId": 2,
      "check_type": "stop"
    }
  },
  "scriptResults": []
}
```

### Фактический результат:

```json
{
  "ruleResults": {
    "violation": "Найдено запрещенное USB-устройство"
  }
}
```
---
## 🔹 BUG-004: GET /v2/check. В ответе возвращает строку вместо JSON

### Серьезность: Critical

### Описание:

Один из ответов (у нас иммитация случайным возвратом комплаенс-статуса) возвращает неккоретный ттип данных. 
Строка ошибки вместо JSON.

### Шаги для воспроизведения

1. Отправить запрос GET http://localhost:4567/v2/check

### Ожидаемый результат:

```json
{
  "ruleResults" : {
    "violation" : "Ошибка сбора информации о статусе нарушений: unknown ERROR"
  }
}
```

### Фактический результат:

```
Ошибка сбора информации о статусе нарушений: unknown ERROR
```
---

## 🔹 BUG-005: GET /software. В ответе присутсвует поле installLocation, которого нет в структуре данных

### Серьезность: Minor

### Описание:

В ответе присутсвует поле installLocation, которого нет в документации. Необходимо уточнить у аналитика/пм необходимо ли данное поле.
Если поле необходимо - добавить его в документацию, если нет - убрать из запроса. 

### Шаги для воспроизведения

1. Отправить запрос GET http://localhost:4567/software

### Ожидаемый результат:
JSON соответствующий структуре данных: 
```json
[
  {
    "displayName": "SoapUI 5.5.0",
    "displayVersion": "5.5.0",
    "arch": "X32",
    "publisher": "SmartBear Software",
    "installDate": "0001-01-01T00:00:00Z",
    "estimatedSize": 0,
    "Contact": "",
    "HelpLink": "",
    "InstallSource": "",
    "VersionMajor": 5,
    "VersionMinor": 5
  }
]
```

### Фактический результат:
Есть поле installLocation
```json
[
  {
    "displayName": "FastStone Image Viewer 7.5",
    "displayVersion": "7.5",
    "arch": "X32",
    "publisher": "FastStone Soft",
    "installDate": "0001-01-01T00:00:00Z",
    "installLocation": "", 
    "estimatedSize": 0,
    "Contact": "",
    "HelpLink": "",
    "InstallSource": "",
    "VersionMajor": 0,
    "VersionMinor": 0
  }
]
```

---
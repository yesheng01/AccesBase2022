﻿(Get-Content "C:\Users\sheng\Origin.txt" | Select-String -Pattern "a|A" -AllMatches).Matches.Count
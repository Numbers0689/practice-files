
annual_salary = float(input("Enter your starting annual salary: "))
portion_saved = 0
total_cost = 1000000
semi_annual_raise = .07
portion_down_payment = 0.25
current_savings = 0.00
r = 0.04
monthly_salary = annual_salary / 12
monthly_saving = monthly_salary * portion_saved
months = 0

while current_savings <= 250000:
    salary = annual_salary
    for i in range(36):
        months += 1
        if months % 6 == 0:
            salary += annual_salary * semi_annual_raise
        current_savings += (current_savings * (r / 12)) + ((salary / 12) * portion_saved)

    if current_savings > 249900:
        break
    if current_savings <= 250000:
        current_savings = 0.00
        portion_saved += .0001
        months = 0
    if portion_saved >= 1.0:
        print("its possible to save")
        break

if portion_saved < 1.00:
    print("Best savings rate: " + str(portion_saved))

print((10000 // 2.0) / 10000)

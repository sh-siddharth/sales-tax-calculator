# Sales Tax Calculator

## Problem Statement

### Background

- Sales tax is applicable at a rate of 10%
- Books, food, and medical products that are exempted from sales tax
- Import duty is an additional tax applicable on all imported goods at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the
items and their price (including tax), finishing with the total cost of the
items, and the total amounts of sales taxes paid. The rounding rules for
sales tax are that for a tax rate of n%, a shelf price of p contains
(np/100 rounded up to the nearest 0.05) amount of sales tax.

Write an application that prints out the receipt details for these shopping
baskets.

### Example

#### Input

    1 book at 12.49
    1 music CD at 14.99
    1 chocolate bar at 0.85

#### Output

    1 book : 12.49
    1 music CD: 16.49
    1 chocolate bar: 0.85
    Sales Taxes: 1.50
    Total: 29.83

## How to use

    > cd path/to/dir/
    > javac *.java
    > java Main <input_file_name>

The input file should be placed in the inputs directory.

## Requirements

- Java 7+

## Notes and assumptions

1. The inputs are always in the given format/order-

    > quantity imported(optional) product_name at price

2. Any line which does not follow the said format will be neglected

3. The products to be categorized are already updated in `ItemTypeDictionary`

4. In case the product is not categorized, it will be treated as _other_, i.e, sales tax will be applicable for the said item.

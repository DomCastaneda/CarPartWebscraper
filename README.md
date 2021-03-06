# Turbo Parts
Searches for car parts and filters out the cheapest option. Go to the seach page
and use the combo boxes to search for specified parts for your car. The search results
will output the cheapest price and a link to the part's provider.

# Running Build Instructions
1. Download TurboParts.zip
2. Open Terminal
3. cd into dist folder
4. java -jar TurboParts.jar

# Check-In 1 Release Notes
## MVP
- Allow users to create an account with an email
- Part Navigation/Search
- Settings Page UI

## Feature 1 - Part Search - Dominic
- Allow users to search for their car parts through comboboxes
- Comboboxes: Make -> Year -> Model -> Part -> Search

## Feature 2 - Shows Cheapest Part Information - Dominic
- The part with the lowest price and its information is outputted to the bottom of the search page

## Feature 3 - Link to Cheapest Website - Dominic
- A hyperlink to the seller's website with the cheapest option is shown at the bottom of the search page

## Feature 4 - Signup Page - Jae
- FXML page to allow users to sign up
- Allow users to create an account by providing their username and password

## Feature 5 - Settings Page - Jae
- Settings page that allows users to enable Dark/Light Mode and change username/passoword

# Check-In 2 Release Notes

## Feature 6 - Error Message / Welcome Message - Jae
- Error message pops up when
    - The users try to sign up with existing account
    - The users try to log in with non existing account or wrong password
- Welcome message pops up when
    - The users successfully log in

## Feature 7 - Account Database - Dominic
- Users can sign up or log in to their created accounts
- User information (username, password) stored on a local SQL database
- Users can sign out on settings page

## Feature 8 - Login Page - Jae
- FXML page to allow users to log in to their accounts
- Users with no account can click link to signup page

## Feature 9 - Recent Search History - Dominic
- Once the user chooses a part, the search history should show recently searched parts 
- Search history shown on bottom of search page

## Feature 10 - Dark mode/Light mode - Jae
- In settings page, user can enable dark mode and light mode 

# References
https://www.youtube.com/watch?v=yw7B85174JQ

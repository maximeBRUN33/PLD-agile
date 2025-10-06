# 🚴‍♂️ Delivery Optimization App  

**INSA Lyon – 3rd Year Project (Group 4131)**  
Contributors : Jean Abou-Moussa, Maxime Brun, Noé Le Blavec, Antoine Vraux, Yanice Boady, Hugo Laface 

The goal of this app is to build an application that optimizes delivery routes and manages courier operations efficiently.    

## Objectives  
- Design and implement a complete delivery management system  
- Develop algorithms (Dijkstra implementation) to optimize courier routes based on the **Travelling Salesman Problem (TSP)**  
- Provide an interactive user interface for managing couriers and deliveries  

## Architecture  
The application follows a **Model-View-Controller (MVC)** architecture:  

- **Model:** Manages data and communicates with the algorithm package  
- **View (IHM):** Built using **JavaFX** for a clear and intuitive user interface  
- **Controller:** Central logic component (`genericController.java`) handling user actions, service calls, and algorithm execution  
  

## Algorithms  
We implemented multiple versions of the **TSP algorithm**, improving efficiency with different heuristics and iterators.  

- For small maps, a simple iterator is used  
- For maps with more than 13 delivery points, a more efficient iterator is automatically selected  

Additional algorithms include:  
- Dijkstra-based shortest path computation  
- Graph simplification based on delivery schedules  
- Dynamic courier assignment  

## User Interface  
Prototyped using **Figma** and developed in **JavaFX**, the app offers two main views:  

1. **Individual Courier View** – Displays assigned deliveries and allows adding/removing points directly on the map  
2. **All Couriers View** – Visualizes all couriers’ routes with filtering options  

### Key UI Features  
- Interactive map with hover highlighting  
- Progress bar to simulate delivery progression  
- Buttons for project management:  
  - `Save Project` (exports data to CSV)  
  - `Open Project` (loads previous sessions)  
  - `Add Courier` (quickly insert a new deliverer)  
- Export routes in **GPX format** (compatible with Google Maps)  

## Testing  
Unit tests were written using **JUnit**.  
Coverage analysis was conducted in **Eclipse**, focusing on:  

- Route calculation across varying map sizes  
- XML parsing performance  

Results showed expected runtime increases with larger datasets.  

## Tools & Technologies  
- **Java / JavaFX** – Core development & UI  
- **Eclipse IDE** – Development & testing  
- **GitHub** – Version control & project management  
- **JUnit** – Unit testing  
- **Figma** – UI prototyping  
- **Scene Builder** – JavaFX front-end design  


### Macro Tasks  
- Requirement analysis & use cases  
- Architecture & design pattern definition  
- UI mockups & layout creation  
- Data model and XML file processing  
- Algorithmic development (TSP, Dijkstra, adjacency lists)  
- UI and functional integration  
- Unit testing & performance evaluation   

## How could it be improved  
- Multi-city or multi-map support  
- Real-time delivery tracking  
- Integration with GPS or external APIs  

---

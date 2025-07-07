import React, { useEffect, useState } from "react";
import axios from "axios";
import ProductCard from "./components/ProductCard";
import "./App.css";
import ProductCarousel from "./components/ProductCarousel";


function App() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:5000/api/products")
      .then((res) => setProducts(res.data))
      .catch((err) => console.error(err));
  }, []);

  return (
    
    <div className="App">
      <h1>Product Listing</h1>
      <ProductCarousel products={products} />
{/* 
      <div className="product-grid">
        {products.map((product, idx) => (
          <ProductCard key={idx} product={product} />
          
        ))}
      </div> */}
    </div>
  );
  const fetchFilteredProducts = async () => {
  try {
    const res = await axios.get("http://localhost:5000/api/products/filter", {
      params: {
        minPrice: 200,
        maxPrice: 800,
        minPopularity: 3.5,
      },
    });
    setProducts(res.data);
  } catch (err) {
    console.error(err);
  }
};

}

export default App;

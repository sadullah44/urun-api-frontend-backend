import React, { useState } from "react";

const ProductCard = ({ product }) => {
  const [selectedColor, setSelectedColor] = useState("yellow");
  console.log("Selected Image URL:", product.images[selectedColor]);

  return (
    <div className="product-card">
      <img
        src={product.images[selectedColor]}
        alt={product.name}
        className="product-image"
      />
      <h3>{product.name}</h3>
      <p><strong>Price:</strong> ${product.price}</p>
      <p><strong>Popularity:</strong> {product.popularity} / 5</p>

      <div className="color-picker">
        {["yellow", "rose", "white"].map((color) => (
          <button
            key={color}
            style={{
              backgroundColor: color,
              border:
                selectedColor === color ? "2px solid black" : "1px solid gray",
              marginRight: "5px",
              width: "20px",
              height: "20px",
              borderRadius: "50%",
              cursor: "pointer",
            }}
            onClick={() => setSelectedColor(color)}
          />
        ))}
      </div>
    </div>
  );
};

export default ProductCard;

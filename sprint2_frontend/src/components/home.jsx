import { Link } from "react-router-dom";
import { GrEmoji } from "react-icons/gr";
const Home = () => {


    return (
      

  <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  
  <div class="carousel-inner">
    <div class="carousel-item active" data-bs-interval="10000">
      <img src=" https://i.pinimg.com/originals/cd/e0/20/cde02007f55e0e63ff230909d35325d8.jpg" class="d-block w-100" alt="..." height="1000px"/>
      <div class="carousel-content1 d-md-block d-sm-block d-lg-inline">
     
        <h1 className="Hungry">Welcome Foodie</h1><hr />
      <p>What are you waiting for?<br /><br />
        <Link to="/restCategory/display">
          <button type="button" className="btn btn-outline-danger ">
            Search Restaurants by category
          </button>
        </Link>
      </p>
        
      </div>
     
    </div>
    <div class="carousel-item" data-bs-interval="2000">
      <img src="https://images.pexels.com/photos/239581/pexels-photo-239581.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" class="d-block w-100" alt="..." height="900px"/>
      <div class="carousel-content  d-md-block d-sm-block d-lg-inline">
      <h1 className="Hungry">HUNGRY..?</h1><hr />
      <p>What are you waiting for?<br /><br />
      <Link to="/restCategory/display">
        <button type="button" className="btn btn-outline-danger ">
           Order Now
         </button>
         </Link>
      </p>
      </div>
    </div>
    <div class="carousel-item"  data-bs-interval="2000">
      <img src="https://img5.goodfon.com/wallpaper/nbig/d/4c/stol-chashka-goriachii-kofe-napitok-par-ziorna-lozhka-doski.jpg" class="d-block w-100" alt="..." height="700px"/>
      <div class="carousel-content2  d-md-block d-sm-block d-lg-inline">
      <h1 className="Hungry">We Serve The Best</h1><hr />
      <p>What are you waiting for?<br /><br />
      <Link to="/restCategory/display">
        <button type="button" className="btn btn-outline-danger ">
           Order Now
         </button>
         </Link>
      </p>
      </div>
    </div>
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>
        
        
    );
};

export default Home


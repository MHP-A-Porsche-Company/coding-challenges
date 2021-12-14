using Xunit;
using MHP.CodingChallenge.Backend.Dependency.Inquiry;
using MHP.CodingChallenge.Backend.Dependency.Inquiry.Interfaces;
using Microsoft.Extensions.DependencyInjection;
using MHP.CodingChallenge.Backend.Dependency.Notifications;
using Moq;

namespace MHP.CodingChallenge.Backend.Dependency.Test
{
    public class InquiryTest
    {
        [Fact]
        public void TestInquiryHandlers()
        {
            // given
            Inquiry.Inquiry inquiry = new Inquiry.Inquiry();
            inquiry.Username = "TestUser";
            inquiry.Recipient = "service@example.com";
            inquiry.Text = "Can I haz cheezburger?";

            // room for potential additional test setup for interfaces 
            var mockEmailHander = new Mock<IEmailHandler>();
            var mockPushNotificationHandler = new Mock<IPushNotificationHandler>();

            var services = new ServiceCollection()
                .AddLogging()
                .AddSingleton<InquiryService>()
                .AddSingleton(mockEmailHander.Object)
                .AddSingleton(mockPushNotificationHandler.Object);
            
            
            var inquiryService = services
                .BuildServiceProvider()
                .GetRequiredService<InquiryService>();

            // when
            inquiryService.Create(inquiry);

            // then, to also verify only once these methods are called 
            mockEmailHander.Verify(e => e.SendEmail(inquiry),Times.Once());
            mockPushNotificationHandler.Verify(e => e.SendNotification(inquiry),Times.Once());
        }
    }
}
